package com.example.heardit.controller;

import com.example.heardit.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<ByteArrayResource> streamMusic() throws IOException {
        // Log the incoming request
        System.out.println("Received request to stream music");
        byte[] musicBytes = musicService.getMusicFile();
        ByteArrayResource resource = new ByteArrayResource(musicBytes);
        return ResponseEntity.ok()
                .contentLength(musicBytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
