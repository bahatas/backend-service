package uk.co.ii.financialtoolsservice.demo.webclient;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customers")
public class DemoController {

    CustomerService customerService;

    public DemoController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }

    @GetMapping(value = "/stream-all",produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Customer> getAllCustomersAsStream() {

      return
              customerService.getAllCustomerFlux().doOnComplete(()->log.info("Completed"));

    }

    @GetMapping(value = "/stream-all-2",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersAsStream2() {

        Flux<Customer> allCustomerFlux = customerService.getAllCustomerFlux();
        return allCustomerFlux;
    }

}
