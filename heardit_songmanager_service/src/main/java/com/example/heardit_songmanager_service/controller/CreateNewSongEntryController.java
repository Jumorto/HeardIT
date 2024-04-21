package com.example.heardit_songmanager_service.controller;

import com.example.heardit_songmanager_service.domain.CreateNewSongEntryRequest;
import com.example.heardit_songmanager_service.domain.CreateNewSongEntryResponse;
import com.example.heardit_songmanager_service.service.use_cases.CreateNewSongEntryUseCase;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Generated
@RestController
@RequestMapping("/api/manage")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CreateNewSongEntryController {
    private final CreateNewSongEntryUseCase createNewSongEntryUseCase;

    @PostMapping()
    public ResponseEntity<CreateNewSongEntryResponse> createNewSongEntry(@RequestBody CreateNewSongEntryRequest request) {
        CreateNewSongEntryResponse response = createNewSongEntryUseCase.createNewSongEntry(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
