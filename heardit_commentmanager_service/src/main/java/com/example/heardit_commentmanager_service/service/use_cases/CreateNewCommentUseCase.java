package com.example.heardit_commentmanager_service.service.use_cases;

import com.example.heardit_commentmanager_service.domain.CreateNewCommentRequest;
import com.example.heardit_commentmanager_service.domain.CreateNewCommentResponse;

public interface CreateNewCommentUseCase {
    CreateNewCommentResponse createNewComment(CreateNewCommentRequest request);
}
