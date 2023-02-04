package uk.co.ii.financialtoolsservice.demo.webclient;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class DemoController {


    CustomerService customerService;

    public DemoController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){

        List<Customer> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }

    @GetMapping("/stream-all")
    public ResponseEntity<Flux<Customer>> getAllCustomersAsStream(){

        Flux<Customer> allCustomerFlux = customerService.getAllCustomerFlux();
        return ResponseEntity.ok(allCustomerFlux);
    }

}
