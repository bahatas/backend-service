package uk.co.ii.financialtoolsservice.financeApp.service;


import uk.co.ii.financialtoolsservice.financeApp.dto.AlphaApiResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class FinanceService {

    @Value("${alphavantage.api.key}")
    private String apikey;

    @Value("${alphavantage.api.url}")
    private String apiUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<AlphaApiResponseDto> getData() {

        String finalTemplateUrl = apiUrl + apikey;


        Mono<AlphaApiResponseDto> alphaApiResponseDtoMono = webClientBuilder.build()
                .get()
                .uri(finalTemplateUrl)
                .retrieve()
                .bodyToMono(AlphaApiResponseDto.class);

        log.info("API DATA RETRIEVED");

        return alphaApiResponseDtoMono;

    }


}
