package com.example.kafkapracticle.kafka;

import com.example.kafkapracticle.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(String userName){
        LOGGER.info(String.format("Name sent %s", userName));
        kafkaTemplate.send(topicName, "Hi " + userName + " Welcome to XYZ services");
        return "Data Published!";
    }

   public String sendMessage(User userOrder){

        LOGGER.info(String.format("Message sent -> %s", userOrder.toString()));

        Message<User> message = MessageBuilder
                .withPayload(userOrder)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
        kafkaTemplate.send(topicJsonName, "Hi" + userOrder.getName() + ", Welcome to Apache Kafka Demo.");
        return "Data Published!";
    }
}
