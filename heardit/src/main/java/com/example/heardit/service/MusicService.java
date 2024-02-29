package com.example.heardit.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class MusicService {

    public byte[] getMusicFile() throws IOException {
        Path filePath = Path.of("E:\\Editing\\Qz. Pchelina - 21-01-2024\\Music\\Nine Lives - Unicorn Heads.mp3");
        return Files.readAllBytes(filePath);
    }
}
