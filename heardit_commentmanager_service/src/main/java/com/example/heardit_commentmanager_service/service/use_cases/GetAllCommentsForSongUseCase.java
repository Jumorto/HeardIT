package com.example.heardit_commentmanager_service.service.use_cases;

import com.example.heardit_commentmanager_service.domain.GetAllCommentsForSongResponse;

public interface GetAllCommentsForSongUseCase {
    GetAllCommentsForSongResponse getAllCommentsForSong(Long idsong);
}
