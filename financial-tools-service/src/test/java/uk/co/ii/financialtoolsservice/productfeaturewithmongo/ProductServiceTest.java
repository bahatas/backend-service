package uk.co.ii.financialtoolsservice.productfeaturewithmongo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void getProductList() {
    }

    @Test
    void savePruduct() {
        ProductDto testProduct = ProductDto.builder()
                .id("test id 0")
                .name("test product")
                .qty(100)
                .price(2500)
                .build();
        Mono<ProductDto> just = Mono.just(testProduct);
        Mono<ProductDto> productDtoMono = productService.savePruduct(just);
        System.out.println("Test completed :"+productDtoMono.log().blockOptional().get().toString());



    }
}