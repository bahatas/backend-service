package uk.co.ii.financialtoolsservice.demo.webclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private String lastName;
    private String phoneNumber;


}
