package com.example.heardit_songmanager_service.service;

import com.example.heardit_songmanager_service.data_access.SongEntity;
import com.example.heardit_songmanager_service.data_access.SongRepository;
import com.example.heardit_songmanager_service.domain.UpdateSongEntryRequest;
import com.example.heardit_songmanager_service.service.exceptions.NotFoundSongEntryException;
import com.example.heardit_songmanager_service.service.use_cases.UpdateSongEntryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateSongEntryUseCaseService implements UpdateSongEntryUseCase {
    private final SongRepository songRepository;

    @Override
    public void updateSongEntry(UpdateSongEntryRequest request){
        Optional<SongEntity> songOptional = songRepository.findById(request.getId());
        SongEntity song;
        if(songOptional.isPresent()){
            song = songOptional.get();
        }else{
            throw new NotFoundSongEntryException("BRAND_ID_INVALID");
        }

        if (!request.getNameTrack().isEmpty() && request.getNameTrack() != "" && request.getNameTrack() != null) {
            song.setNametrack(request.getNameTrack());
        }

        if (request.getFileTrack() != null) {
            song.setFiletrack(request.getFileTrack());
        }

        songRepository.save(song);
    }
}
