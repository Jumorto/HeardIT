package com.example.heardit_commentmanager_service.service.converter;

import com.example.heardit_commentmanager_service.domain.Comment;

import java.util.Date;

public class CommentConverter {
    private CommentConverter(){

    }

    public static Comment convert(Object[] commentEntity){
        return Comment.builder()
                .id((Long)commentEntity[0])
                .useremail((String)commentEntity[1])
                .idsong((Long)commentEntity[2])
                .commenttext((String)commentEntity[3])
                .commentdate((Date)commentEntity[4])
                .build();
    }
}
