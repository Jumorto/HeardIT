package com.example.heardit.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Getter
@Setter
@Service
public class MusicService {

    //private Path filePath = Path.of("songResources\\NineLives-UnicornHeads.mp3");
    private Path filePath = Path.of("/opt/app/songResources/NineLives-UnicornHeads.mp3");

    public byte[] getMusicFile() throws IOException {
        System.out.println("Getting song----------------");
        return Files.readAllBytes(filePath);
    }
//    public byte[] getMusicFile() throws IOException {
//        Path filePath = Path.of("E:\\Editing\\music\\Nine Lives - Unicorn Heads.mp3");
//        //Path filePath = Path.of("E:\\Editing\\music\\" + songName + ".mp3"); String songName
//        return Files.readAllBytes(filePath);
//    }

//    public MusicService(@Value("${music.file.path}") String filePath) {
//        this.filePath = Path.of(filePath);
//    }
//    public List<String> getAvailableSongs() {
//        return Arrays.asList("Nine Lives - Unicorn Heads", "Don't Fret - Quincas Moreira", "song3", "song4", "song5", "song6", "song7", "song8", "song9", "song10");
//    }
}
