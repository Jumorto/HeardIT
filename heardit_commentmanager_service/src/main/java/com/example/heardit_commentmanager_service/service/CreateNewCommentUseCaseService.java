package com.example.heardit_commentmanager_service.service;

import com.example.heardit_commentmanager_service.data_access.CommentEntity;
import com.example.heardit_commentmanager_service.data_access.CommentRepository;
import com.example.heardit_commentmanager_service.domain.CreateNewCommentRequest;
import com.example.heardit_commentmanager_service.domain.CreateNewCommentResponse;
import com.example.heardit_commentmanager_service.service.use_cases.CreateNewCommentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CreateNewCommentUseCaseService implements CreateNewCommentUseCase {
    private final CommentRepository commentRepository;

    @Override
    public CreateNewCommentResponse createNewComment(CreateNewCommentRequest request) {
        CommentEntity savedSong = saveNewCommentEntity(request);

        return CreateNewCommentResponse.builder()
                .id(savedSong.getId())
                .build();
    }

    private CommentEntity saveNewCommentEntity(CreateNewCommentRequest request) {

        CommentEntity newCommentEntity = CommentEntity.builder()
                .useremail(request.getUseremail())
                .idsong(request.getIdsong())
                .commenttext(request.getCommenttext())
                .commentdate(new Date())
                .build();
        CommentEntity savedSongEntity = commentRepository.save(newCommentEntity);
        return savedSongEntity;
    }
}
