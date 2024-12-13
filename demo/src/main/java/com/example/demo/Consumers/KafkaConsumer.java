package com.example.demo.Consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "dev", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
