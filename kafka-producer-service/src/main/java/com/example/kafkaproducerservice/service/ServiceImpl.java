package com.example.kafkaproducerservice.service;


import com.example.kafkaproducerservice.config.ChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ServiceImpl {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private KafkaTemplate<String,String> kafkaTemplate;

    public ServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(){
        // to read real time stream data use event source

        log.info("- SEND MESSAGE COMMAND -");

        EventHandler eventHandler = new ChangesHandler(kafkaTemplate,topicName);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource eventsource= new EventSource.Builder(eventHandler, URI.create(url)).build();
        log.info("event source started {}",eventsource.getLastEventId() );
        eventsource.start();
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            log.warn("10 MINUTES");
            throw new RuntimeException(e);
        }


    }
}
