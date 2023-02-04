package uk.co.ii.financialtoolsservice;

import io.netty.handler.flush.FlushConsolidationHandler;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class ReactiveTestClass {

    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("test data for mono")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();

        monoString.subscribe(System.out::println, (error) -> System.out.println(error.getMessage()));

    }

    @Test
    public void testFlux() {

        List<String> test = List.of("one", "two", "three", "four");

        Flux<String> stringFlux = Flux.just("Test", "Data", "For", "Flux").log();

        Flux<List<String>> log = Flux.just(test).log();


        stringFlux.subscribe(System.out::println);
        log.subscribe(System.out::println);
    }


    @Test
    public void testFlux2() {
        Flux<String> log = Flux.just("Test", "Data", "For", "Flux")
                .concatWithValues("_concatString")
                .concatWith(Flux.error(()->new RuntimeException("Flux error happened")))

                .log();

        log.subscribe(System.out::println,(error)->System.out.println(error));

    }
}
