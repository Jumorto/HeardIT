package com.example.heardit_commentmanager_service.domain;

import lombok.*;

@Generated
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewCommentRequest {
    private Long idsong;
    private String useremail;
    private String commenttext;
}
