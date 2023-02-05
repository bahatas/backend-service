package uk.co.ii.financialtoolsservice.demo.handlerRouter;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uk.co.ii.financialtoolsservice.demo.webclient.Customer;
import uk.co.ii.financialtoolsservice.demo.webclient.CustomerDataProvider;

import java.util.function.Predicate;

@Service
public class CustomerHandler {


    CustomerDataProvider customerDataProvider;

    public CustomerHandler(CustomerDataProvider customerDataProvider) {
        this.customerDataProvider = customerDataProvider;
    }

    public Mono<ServerResponse> loadCustomers(ServerRequest serverRequest) {

        Flux<Customer> customerList = customerDataProvider.getCustomerList();
        Mono<ServerResponse> body = ServerResponse.ok().body(customerList, Customer.class);
        return body;


    }

    public Mono<ServerResponse> findCustomer(ServerRequest request) {

        String input = String.valueOf(request.pathVariable("input"));
//        Predicate predicate = (Object i ) -> i==input;
//        customerDataProvider.getCustomerList().filter(predicate)
        Mono<Customer> next = customerDataProvider.getCustomerList().filter(each -> each.getName().equals(input) || each.getName().startsWith(input.substring(0,1))).next();
        return ServerResponse.ok().body(next, Customer.class);


    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request) {
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<String> map = customerMono.map(dto -> dto.getId() + " :" + dto.getName());

        return ServerResponse.ok().body(map, String.class);

    }
}
