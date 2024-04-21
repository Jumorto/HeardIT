package com.example.heardit_songmanager_service.service.use_cases;

import com.example.heardit_songmanager_service.domain.CreateNewSongEntryRequest;
import com.example.heardit_songmanager_service.domain.CreateNewSongEntryResponse;

public interface CreateNewSongEntryUseCase{
    CreateNewSongEntryResponse createNewSongEntry(CreateNewSongEntryRequest request);
}
