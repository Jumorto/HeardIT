package com.example.heardit_songmanager_service.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "userDeletionQueue";

    @Bean
    public Queue userDeletionQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}
