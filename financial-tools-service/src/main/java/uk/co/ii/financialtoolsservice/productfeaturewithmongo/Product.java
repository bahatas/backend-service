package uk.co.ii.financialtoolsservice.productfeaturewithmongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")    // this is not collation

public class Product {


    @Id
    private String id;
    private String name;
    private int qty;
    private double price;
}
