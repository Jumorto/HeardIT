package com.example.heardit_commentmanager_service.service;

import com.example.heardit_commentmanager_service.data_access.CommentRepository;
import com.example.heardit_commentmanager_service.domain.Comment;
import com.example.heardit_commentmanager_service.domain.GetAllCommentsForSongResponse;
import com.example.heardit_commentmanager_service.service.converter.CommentConverter;
import com.example.heardit_commentmanager_service.service.use_cases.GetAllCommentsForSongUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllCommentsForSongUseCaseService implements GetAllCommentsForSongUseCase {
    private CommentRepository commentRepository;

    @Override
    public GetAllCommentsForSongResponse getAllCommentsForSong(Long idsong){
        List<Object[]> results;
        results = commentRepository.findCommentsBySongId(idsong);

        final GetAllCommentsForSongResponse response = new GetAllCommentsForSongResponse();
        List<Comment> comments = results.stream().map(CommentConverter::convert).toList();
        response.setComments(comments);
        return response;
    }
}
