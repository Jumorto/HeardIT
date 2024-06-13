package com.example.heardit_commentmanager_service.data_access;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Generated
@Entity
@Table(name = "songcomments")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "useremail")
    private String useremail;

    @Column(name = "idsong")
    private Long idsong;

    @Column(name = "commenttext")
    private String commenttext;

    @Column(name = "commentdate")
    private Date commentdate;
}
