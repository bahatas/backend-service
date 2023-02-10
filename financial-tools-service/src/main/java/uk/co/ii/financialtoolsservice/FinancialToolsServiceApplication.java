package uk.co.ii.financialtoolsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FinancialToolsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialToolsServiceApplication.class, args);
    }

}
