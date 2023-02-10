package uk.co.ii.financialtoolsservice.productfeaturewithmongo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "products")
public class Product {


    private String id;
    private String name;
    private int qty;
    private double price;
}
