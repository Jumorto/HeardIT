package com.example.heardit.service.use_cases;

import com.example.heardit.domain.GetSongByIdResponse;

public interface GetSongByIdUseCase {
    GetSongByIdResponse getSongById(long id);
}
