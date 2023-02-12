package uk.co.ii.financialtoolsservice.productfeaturewithmongo;


import com.github.javafaker.Faker;
import com.github.javafaker.Space;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductService {


    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<ProductDto> getProductList() {

        log.info("Retrieve all products from mongo repo");
        return productRepository.findAll().map(MapperUtil::entityToDto);
    }

    public Mono<ProductDto> savePruduct(Mono<ProductDto> productDtoMono) {

//        todo try this simple method
        Faker faker = new Faker();
        String space = faker.space().star();
        log.info("service method called ...");
        Mono<Product> map = productDtoMono.map(MapperUtil::dtoToEntity);
        Mono<Product> productMono = map.flatMap(entity -> productRepository.save(entity));

        return productMono.map(MapperUtil::entityToDto);

        /**
         *
         *  This is an alternative but hard to test code parts
         *
         System.out.println("service method called ...");
         return productDtoMono.map(MapperUtil::dtoToEntity)
         .flatMap(productRepository::insert)
         .map(MapperUtil::entityToDto);
         */


    }

    public Mono<ProductDto> getproductById(String id) {

        Mono<ProductDto> map = productRepository.findById(id).map(MapperUtil::entityToDto).log();
        log.info("Product found : {}", map.toString());

        return map;
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productMono, String id) {


        return productRepository.findById(id)
                .flatMap(p->productMono.map(MapperUtil::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(productRepository::save)
                .map(MapperUtil::entityToDto);
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}
