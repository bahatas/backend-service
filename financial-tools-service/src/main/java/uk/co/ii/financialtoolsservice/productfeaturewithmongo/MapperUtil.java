package uk.co.ii.financialtoolsservice.productfeaturewithmongo;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    public static ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        return product;

    }
}