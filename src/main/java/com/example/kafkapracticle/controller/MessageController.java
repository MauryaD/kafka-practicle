package com.example.kafkapracticle.controller;

import com.example.kafkapracticle.entity.UserOrder;
import com.example.kafkapracticle.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        for(int i=0; i<10; i++) {
            kafkaProducer.sendMessage(message + i);
        }
        return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("/publish/json")
    public ResponseEntity<String> publish(@RequestBody UserOrder userOrder){
        kafkaProducer.sendMessage(userOrder);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
