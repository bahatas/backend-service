package uk.co.ii.financialtoolsservice.service;

import uk.co.ii.financialtoolsservice.financeApp.dto.AlphaApiResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import uk.co.ii.financialtoolsservice.financeApp.service.FinanceService;


@SpringBootTest
@Slf4j
class FinanceServiceTest {

    @Autowired
    FinanceService financeService;

    @Test
    void getData() {

        Mono<AlphaApiResponseDto> data = financeService.getData();

        log.info("data retrieved {}",data.block().getMetaData().outputSize);
    }
}