package com.example.heardit.controller;

import com.example.heardit.domain.GetSongByIdResponse;
import com.example.heardit.service.use_cases.GetSongByIdUseCase;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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

//    @GetMapping(value = "/stream/{id}")
//    public ResponseEntity<StreamingResponseBody> streamMusic(@PathVariable("id") long id) {
//        // Log the incoming request
//        System.out.println("Received request to stream music");
//
//        GetSongByIdResponse response = getSongByIdUseCase.getSongById(id);
//        byte[] musicBytes = response.getSong().getFiletrack();
//
//        InputStream inputStream = new ByteArrayInputStream(musicBytes);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(id + ".mp3").build());
//
//        StreamingResponseBody responseBody = outputStream -> {
//            try {
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//                inputStream.close();
//            } catch (IOException e) {
//                throw new RuntimeException("Error streaming music: " + e.getMessage());
//            }
//        };
//
//        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
//    }
}
