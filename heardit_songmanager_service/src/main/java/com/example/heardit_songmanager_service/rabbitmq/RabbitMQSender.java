package com.example.heardit_songmanager_service.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendUserDeletionMessage(String useremail) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, useremail);
    }
}