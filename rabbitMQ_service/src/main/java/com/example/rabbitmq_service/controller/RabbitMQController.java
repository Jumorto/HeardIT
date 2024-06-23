package com.example.rabbitmq_service.controller;

import com.example.rabbitmq_service.service.RabbitMQSender;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Generated
@RestController
@RequestMapping("/api/rabbitmq")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "https://heardit-frontend-slsv6nh5ga-ez.a.run.app"} )
public class RabbitMQController {
    private final RabbitMQSender rabbitMQSender;
    @DeleteMapping("/alluseremail")
    public ResponseEntity<Void> deleteAllSongEntryByUseremail(@RequestParam(value = "useremail", required = true) String useremail) {
        // Send a message to RabbitMQ to delete user data
        rabbitMQSender.sendUserDeletionMessage(useremail);
        return ResponseEntity.noContent().build();
    }
}

