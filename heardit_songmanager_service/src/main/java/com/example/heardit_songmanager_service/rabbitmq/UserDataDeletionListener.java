package com.example.heardit_songmanager_service.rabbitmq;

import com.example.heardit_songmanager_service.service.use_cases.DeleteSongEntryUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataDeletionListener {

    @Autowired
    private DeleteSongEntryUseCase deleteSongEntryUseCase;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleUserDeletion(String useremail) {
        deleteAllUserData(useremail);
    }

    private void deleteAllUserData(String useremail) {
        System.out.println("Deleting all data for user with email: " + useremail);
        deleteSongEntryUseCase.deleteSongEntryByUserEmail(useremail);
    }
}
