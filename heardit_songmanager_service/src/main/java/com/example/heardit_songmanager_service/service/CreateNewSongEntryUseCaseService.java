package com.example.heardit_songmanager_service.service;

import com.example.heardit_songmanager_service.data_access.SongEntity;
import com.example.heardit_songmanager_service.data_access.SongRepository;
import com.example.heardit_songmanager_service.domain.CreateNewSongEntryRequest;
import com.example.heardit_songmanager_service.domain.CreateNewSongEntryResponse;
import com.example.heardit_songmanager_service.service.use_cases.CreateNewSongEntryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateNewSongEntryUseCaseService implements CreateNewSongEntryUseCase {
    private final SongRepository songRepository;

    @Override
    public CreateNewSongEntryResponse createNewSongEntry(CreateNewSongEntryRequest request) {
        SongEntity savedSong = saveNewSongEntry(request);

        return CreateNewSongEntryResponse.builder()
                .id(savedSong.getId())
                .build();
    }

    private SongEntity saveNewSongEntry(CreateNewSongEntryRequest request) {

        SongEntity newSongEntity = SongEntity.builder()
                .nametrack(request.getNameTrack())
                .filetrack(request.getFileTrack())
                .build();
        SongEntity savedSongEntity = songRepository.save(newSongEntity);
        return savedSongEntity;
    }
}
