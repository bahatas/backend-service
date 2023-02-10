package uk.co.ii.financialtoolsservice.productfeaturewithmongo;


import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping()
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDto) {
        Mono<ProductDto> productDtoMono = productService.savePruduct(productDto);
        log.info("Product saved to mongo");
        return productDto;


    }

    @GetMapping("/list")
    public Flux<ProductDto> getAllProducts() {

        Flux<ProductDto> productList = productService.getProductList();

        log.info("Retrieved list");

        return productList;

    }
}
