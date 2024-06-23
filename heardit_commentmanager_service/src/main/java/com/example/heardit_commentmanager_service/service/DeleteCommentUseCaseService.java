package com.example.heardit_commentmanager_service.service;

import com.example.heardit_commentmanager_service.data_access.CommentRepository;
import com.example.heardit_commentmanager_service.service.use_cases.DeleteCommentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCommentUseCaseService implements DeleteCommentUseCase {
    private final CommentRepository commentRepository;

    @Override
    public void deleteCommentByUserEmail(String useremail) {
        this.commentRepository.deleteAllByUserEmail(useremail);
    }
}
