package com.example.heardit_commentmanager_service.controller;

import com.example.heardit_commentmanager_service.domain.GetAllCommentsForSongResponse;
import com.example.heardit_commentmanager_service.service.use_cases.GetAllCommentsForSongUseCase;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Generated
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://heardit-frontend-slsv6nh5ga-ez.a.run.app"} )
@AllArgsConstructor
@RequestMapping("/api/comment")
public class GetAllCommentsForSongController {
    private final GetAllCommentsForSongUseCase getAllCommentsForSong;

    @GetMapping() //http://localhost:8084/api/comment?idsong=1
    public ResponseEntity<GetAllCommentsForSongResponse> getAllSongs(@RequestParam(value = "idsong", required = false) Long idsong){
        GetAllCommentsForSongResponse response = getAllCommentsForSong.getAllCommentsForSong(idsong);
        return ResponseEntity.ok(response);
    }
}
