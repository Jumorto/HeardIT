package com.example.heardit.service;

import com.example.heardit.data_access.SongEntity;
import com.example.heardit.data_access.SongRepository;
import com.example.heardit.domain.GetSongByIdResponse;
import com.example.heardit.domain.Song;
import com.example.heardit.service.converter.SongConverter;
import com.example.heardit.service.exeptions.NotFoundSongException;
import com.example.heardit.service.use_cases.GetSongByIdUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@Service
@AllArgsConstructor
public class GetSongByIdUseCaseService implements GetSongByIdUseCase {
    private SongRepository songRepository;

    @Override
    public GetSongByIdResponse getSongById(long id) {

        Optional<SongEntity> result = songRepository.findById(id);
        SongEntity songEntity = result.get();
        Song song = SongConverter.convert(songEntity);
        GetSongByIdResponse response = new GetSongByIdResponse();
        if (song == null) {
            throw new NotFoundSongException("SONG_ID_INVALID");
        } else {
            response.setSong(song);
        }
        return response;
    }
}
