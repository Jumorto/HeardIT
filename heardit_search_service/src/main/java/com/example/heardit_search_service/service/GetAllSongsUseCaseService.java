package com.example.heardit_search_service.service;

import com.example.heardit_search_service.data_access.SongRepository;
import com.example.heardit_search_service.domain.GetAllSongsRequest;
import com.example.heardit_search_service.domain.GetAllSongsResponse;
import com.example.heardit_search_service.domain.Song;
import com.example.heardit_search_service.service.converter.SongConverter;
import com.example.heardit_search_service.service.use_cases.GetAllSongsUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@AllArgsConstructor
public class GetAllSongsUseCaseService implements GetAllSongsUseCase {
    private SongRepository songRepository;

    @Override
    public GetAllSongsResponse getAllSongs(GetAllSongsRequest request){
        List<Object[]> results;
        results = songRepository.findSongsByGivenParameters(request.getNametrack(), request.getUseremail());

        final GetAllSongsResponse response = new GetAllSongsResponse();
        List<Song> songs = results.stream().map(SongConverter::convert).toList();
        response.setSongs(songs);
        return response;
    }
}
