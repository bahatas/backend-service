package uk.co.ii.financialtoolsservice.demo.webclient;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService

{
    CustomerDataProvider customerDataProvider;

    public CustomerService(CustomerDataProvider customerDataProvider) {
        this.customerDataProvider = customerDataProvider;
    }


    public List<Customer> getAllCustomer(){
        return customerDataProvider.getCustomer();
    }
    public Flux<Customer> getAllCustomerFlux(){
        return customerDataProvider.getCustomerStream();
    }
}
