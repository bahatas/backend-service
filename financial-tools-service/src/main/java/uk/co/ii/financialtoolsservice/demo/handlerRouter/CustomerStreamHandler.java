package uk.co.ii.financialtoolsservice.demo.handlerRouter;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uk.co.ii.financialtoolsservice.demo.webclient.Customer;
import uk.co.ii.financialtoolsservice.demo.webclient.CustomerDataProvider;

@Service
public class CustomerStreamHandler {

    CustomerDataProvider customerDataProvider;

    public CustomerStreamHandler(CustomerDataProvider customerDataProvider) {
        this.customerDataProvider = customerDataProvider;
    }

    public Mono<ServerResponse> getCustomer(ServerRequest request){

        Flux<Customer> customerStream = customerDataProvider.getCustomerStream();
        Mono<ServerResponse> body = ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM).body(customerStream, Customer.class);
        return body;
    }
}
