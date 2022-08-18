package com.example.kafkapracticle.controller;

import com.example.kafkapracticle.entity.User;
import com.example.kafkapracticle.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private KafkaProducer kafkaProducer;

    public RegistrationController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/register")
    public ResponseEntity<String> publish(@RequestParam("name") String name){
        kafkaProducer.sendMessage(name);
        return ResponseEntity.ok("Name sent to the topic");
    }

    @PostMapping("/register")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("User Json message sent to kafka topic");
    }
}
