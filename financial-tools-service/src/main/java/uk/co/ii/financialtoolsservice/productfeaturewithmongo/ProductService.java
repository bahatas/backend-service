package uk.co.ii.financialtoolsservice.productfeaturewithmongo;


import com.github.javafaker.Faker;
import com.github.javafaker.Space;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {


    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<ProductDto> getProductList() {

        return productRepository.findAll().map(MapperUtil::entityToDto);
    }

    public Mono<ProductDto> savePruduct(Mono<ProductDto> productDtoMono) {
//        todo try this simple method
        Faker faker = new Faker();
        String space = faker.space().star();
        System.out.println("service method called ...");
        Mono<Product> map = productDtoMono.map(MapperUtil::dtoToEntity);
        Mono<Product> productMono = map.flatMap(entity -> productRepository.save(entity));

        return productMono.map(entity -> MapperUtil.entityToDto(entity));


//        System.out.println("service method called ...");
//        return productDtoMono.map(MapperUtil::dtoToEntity)
//                .flatMap(productRepository::insert)
//                .map(MapperUtil::entityToDto);
//
//    }
    }
}
