package com.example.heardit_commentmanager_service.domain;

import lombok.*;

import java.util.Date;

@Generated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private String useremail;
    private Long idsong;
    private String commenttext;
    private Date commentdate;
}
