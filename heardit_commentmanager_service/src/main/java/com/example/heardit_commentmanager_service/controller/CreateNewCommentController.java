package com.example.heardit_commentmanager_service.controller;

import com.example.heardit_commentmanager_service.domain.CreateNewCommentRequest;
import com.example.heardit_commentmanager_service.domain.CreateNewCommentResponse;
import com.example.heardit_commentmanager_service.service.use_cases.CreateNewCommentUseCase;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Generated
@RestController
@RequestMapping("/api/comment")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "https://heardit-frontend-slsv6nh5ga-ez.a.run.app"})
public class CreateNewCommentController {
    private final CreateNewCommentUseCase createNewCommentUseCase;

    @PostMapping()
    public ResponseEntity<CreateNewCommentResponse> createNewComment(@RequestBody CreateNewCommentRequest request) {
        CreateNewCommentResponse response = createNewCommentUseCase.createNewComment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
