package com.example.heardit_songmanager_service.controller;

import com.example.heardit_songmanager_service.domain.UpdateSongEntryRequest;
import com.example.heardit_songmanager_service.service.use_cases.UpdateSongEntryUseCase;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Generated
@RestController
@RequestMapping("/api/manage")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "https://heardit-frontend-slsv6nh5ga-ez.a.run.app"})
public class UpdateSongEntryController {

    private final UpdateSongEntryUseCase updateSongEntryUseCase;

    @PutMapping("{id}")
    public ResponseEntity<Void> updateSongEntry(@PathVariable("id") long id, @RequestBody UpdateSongEntryRequest request) {
        request.setId(id);
        updateSongEntryUseCase.updateSongEntry(request);
        return ResponseEntity.noContent().build();
    }
}
