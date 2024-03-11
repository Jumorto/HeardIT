package com.example.heardit.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class MusicService {

    public byte[] getMusicFile() throws IOException {
        Path filePath = Path.of("E:\\Editing\\music\\Nine Lives - Unicorn Heads.mp3");
        //Path filePath = Path.of("E:\\Editing\\music\\" + songName + ".mp3"); String songName
        return Files.readAllBytes(filePath);
    }

    public List<String> getAvailableSongs() {
        // Example: Assuming song files are named as "song1.mp3", "song2.mp3", etc.
        return Arrays.asList("Nine Lives - Unicorn Heads", "Don't Fret - Quincas Moreira", "song3", "song4", "song5", "song6", "song7", "song8", "song9", "song10");
    }
}
