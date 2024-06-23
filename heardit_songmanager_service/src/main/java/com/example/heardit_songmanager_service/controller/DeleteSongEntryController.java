package com.example.heardit_songmanager_service.controller;

import com.example.heardit_songmanager_service.service.use_cases.DeleteSongEntryUseCase;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Generated
@RestController
@RequestMapping("/api/manage")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "https://heardit-frontend-slsv6nh5ga-ez.a.run.app"} )
public class DeleteSongEntryController {
    private final DeleteSongEntryUseCase deleteSongEntryUseCase;

    @DeleteMapping()
    public ResponseEntity<Void> deleteSongEntry(@RequestParam(value = "id", required = true) Long id) {
        deleteSongEntryUseCase.deleteSongEntry(id);
        return ResponseEntity.noContent().build();
    }
}
