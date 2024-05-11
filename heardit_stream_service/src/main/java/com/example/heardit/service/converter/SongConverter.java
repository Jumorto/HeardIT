package com.example.heardit.service.converter;

import com.example.heardit.data_access.SongEntity;
import com.example.heardit.domain.Song;

public class SongConverter {
    private SongConverter(){

    }

    public static Song convert(SongEntity songEntity){
        return Song.builder()
                .id(songEntity.getId())
                .nametrack(songEntity.getNametrack())
                .filetrack(songEntity.getFiletrack())
                .build();
    }
}
