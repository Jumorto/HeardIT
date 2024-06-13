package com.example.heardit_commentmanager_service.domain;

import lombok.*;

import java.util.List;

@Generated
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCommentsForSongResponse {
    private List<Comment> comments;
}
