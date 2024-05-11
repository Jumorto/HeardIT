package com.example.heardit_search_service.service.use_cases;

import com.example.heardit_search_service.domain.GetAllSongsRequest;
import com.example.heardit_search_service.domain.GetAllSongsResponse;

public interface GetAllSongsUseCase {
    GetAllSongsResponse getAllSongs(GetAllSongsRequest request);
}
