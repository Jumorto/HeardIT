package com.example.heardit_search_service.service.converter;

import com.example.heardit_search_service.domain.Song;

public class SongConverter {
    private SongConverter(){

    }

    public static Song convert(Object[] songEntity){
        return Song.builder()
                .id((Long)songEntity[0])
                .nametrack((String)songEntity[1])
                .useremail((String)songEntity[2])
                .build();
    }
}
