package uk.co.ii.financialtoolsservice.financeApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import uk.co.ii.financialtoolsservice.financeApp.service.GreetingHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false) //todo check for true option as well
public class Config {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }


    /**
     * The router listens for traffic on the /hello path and returns the value provided by our reactive handler class.
     *
     * @param greetingHandler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> routeRequests(GreetingHandler greetingHandler) {

        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::sayHello);

    }
}
