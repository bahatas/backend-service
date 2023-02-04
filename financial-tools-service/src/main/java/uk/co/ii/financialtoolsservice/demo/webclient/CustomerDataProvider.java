package uk.co.ii.financialtoolsservice.demo.webclient;


import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDataProvider {

    Faker faker = new Faker();


    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public List<Customer> getCustomer() {
        return IntStream.rangeClosed(1, 10)
                .peek(CustomerDataProvider::sleepExecution)
                .peek(i -> System.out.println("processing Count :" + i))
                .mapToObj(i -> Customer.builder().name(faker.name().firstName()).lastName(faker.name().lastName()).phoneNumber(faker.phoneNumber().phoneNumber()).build())
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream() {
        Flux<Customer> map = Flux.range(1, 10)
                .delayElements(Duration.of(1, ChronoUnit.SECONDS))
                .doOnNext(i -> System.out.println("processing count in stream flow: " + i))
                .map(i -> Customer.builder().name(faker.name().firstName()).lastName(faker.name().lastName()).phoneNumber(faker.phoneNumber().phoneNumber()).build());

        return map;
    }

}