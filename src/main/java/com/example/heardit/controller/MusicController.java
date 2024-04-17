package com.example.heardit.controller;

import com.example.heardit.domain.GetSongByIdResponse;
import com.example.heardit.service.use_cases.GetSongByIdUseCase;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Generated
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RequestMapping("/api/music")
public class MusicController {

    private final GetSongByIdUseCase getSongByIdUseCase;

    @GetMapping(value = "/stream/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<ByteArrayResource> streamMusic(@PathVariable("id") long id) {
        // Log the incoming request
        System.out.println("Received request to stream music");
        //byte[] musicBytes = musicService.getMusicFile(songName); // OLD

        GetSongByIdResponse response = getSongByIdUseCase.getSongById(id);
        byte[] musicBytes = response.getSong().getFiletrack();
        ByteArrayResource resource = new ByteArrayResource(musicBytes);
        return ResponseEntity.ok()
                .contentLength(musicBytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
