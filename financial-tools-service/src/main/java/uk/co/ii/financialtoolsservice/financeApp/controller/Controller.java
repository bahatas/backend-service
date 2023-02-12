package uk.co.ii.financialtoolsservice.financeApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import uk.co.ii.financialtoolsservice.financeApp.dto.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import uk.co.ii.financialtoolsservice.financeApp.dto.Post;

@RestController
@RequestMapping("api/v1/finance")
@Slf4j
public class Controller {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/hello")
    public Mono<Greeting> sayHello() {
        Mono<Greeting> hello = webClientBuilder.build()
                .get()
                .uri("hello")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Greeting.class);



        return null;


    }

    @GetMapping("/data")
    public Mono<ResponseEntity<String>> getData() {

        return Mono.empty();
    }

    private final String POST_OF_API = "http://jsonplaceholder.typicode.com/posts/9";
    private final String POST_BY_ID_API = "http://jsonplaceholder.typicode.com/posts/{id}";
    private final String POST_API = "http://jsonplaceholder.typicode.com/posts";




    /**
     * getPost() method call the defined API (static post)
     */
    @GetMapping("/comsume")
    public Post getPost() {

        return webClientBuilder.build()
                .get()
                .uri(POST_OF_API)
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }

    /**
     * getPostById() method call the API with the post id send by the user (dynamic post)
     */
    @GetMapping("/comsume/{id}")
    public Post getPostById(@PathVariable("id") Integer postId) {

        return webClientBuilder.build()
                .get()
                .uri(POST_BY_ID_API, postId)
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }

    /**
     * getAllPost() method call the API which returns the array or list of post
     */
    @GetMapping("/comsume/all")
    public Post[] getAllPost() {

        return webClientBuilder.build()
                .get()
                .uri(POST_API)
                .retrieve()
                .bodyToMono(Post[].class)
                .block();
    }

}
