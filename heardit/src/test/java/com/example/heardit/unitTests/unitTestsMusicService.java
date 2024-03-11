package com.example.heardit.unitTests;
import com.example.heardit.service.MusicService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
public class unitTestsMusicService {

    @TempDir
    Path tempDir;

    @Test
    void testGetMusicFile() throws IOException {
        MusicService musicService = new MusicService();

        // Create a temporary file within the temporary directory
        Path testFilePath = Files.createTempFile(tempDir, "test", ".mp3");
        Files.write(testFilePath, "Mocked music content".getBytes());
        musicService.setFilePath(testFilePath);

        // Call the method under test
        byte[] actualBytes = musicService.getMusicFile();

        // Read content of the temporary file for comparison
        byte[] expectedBytes = Files.readAllBytes(testFilePath);

        // Assert the result
        assertArrayEquals(expectedBytes, actualBytes);
    }
}
