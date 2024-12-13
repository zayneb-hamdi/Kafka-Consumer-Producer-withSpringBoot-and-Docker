package com.example.demo.Controllers;

import com.example.demo.Producers.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer producer;

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message") String message) {
        producer.sendMessage(message);
        return "Message sent to Kafka "+message;
    }
}
