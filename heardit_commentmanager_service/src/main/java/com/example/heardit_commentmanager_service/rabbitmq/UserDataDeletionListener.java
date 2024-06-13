package com.example.heardit_commentmanager_service.rabbitmq;

import com.example.heardit_commentmanager_service.service.use_cases.DeleteCommentUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataDeletionListener {

    @Autowired
    private DeleteCommentUseCase deleteCommentUseCase;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleUserDeletion(String useremail) {
        deleteAllUserData(useremail);
    }

    private void deleteAllUserData(String useremail) {
        System.out.println("Deleting all data for user with email: " + useremail);
        deleteCommentUseCase.deleteCommentByUserEmail(useremail);
    }
}
