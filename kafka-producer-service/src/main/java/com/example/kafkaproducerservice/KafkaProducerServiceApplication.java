package com.example.kafkaproducerservice;

import com.example.kafkaproducerservice.config.ChangesHandler;
import com.example.kafkaproducerservice.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serial;

@SpringBootApplication
public class KafkaProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerServiceApplication.class, args);

    }

    @Autowired
    private ServiceImpl service;
    public void run(String... args){
        service.sendMessage();
    }

}
