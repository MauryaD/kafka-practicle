package com.example.kafkapracticle.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    @Bean
    public NewTopic demoTopic(){
        return TopicBuilder.name(topicName)
                .replicas(1)
                .partitions(1)
                .build();
    }

    @Bean
    public NewTopic demoJsonTopic(){
        return TopicBuilder.name(topicJsonName)
                .replicas(1)
                .partitions(1)
                .build();
    }
}
