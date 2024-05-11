package com.example.heardit_songmanager_service.service;

import com.example.heardit_songmanager_service.data_access.SongRepository;
import com.example.heardit_songmanager_service.service.use_cases.DeleteSongEntryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteSongEntryUseCaseService implements DeleteSongEntryUseCase {
    private final SongRepository songRepository;

    @Override
    public void deleteSongEntry(long id) {
        this.songRepository.deleteById(id);
    }
}
