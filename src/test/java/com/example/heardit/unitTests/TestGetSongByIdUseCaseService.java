package com.example.heardit.unitTests;
import com.example.heardit.data_access.SongEntity;
import com.example.heardit.data_access.SongRepository;
import com.example.heardit.domain.GetSongByIdResponse;
import com.example.heardit.service.GetSongByIdUseCaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestGetSongByIdUseCaseService {
    @Mock
    private SongRepository songRepository;

    @InjectMocks
    private GetSongByIdUseCaseService getSongByIdUseCaseService;

    @Test
    void testGetSongById() {
        // Mocking data
        long id = 1L;
        SongEntity songEntity = new SongEntity();
        songEntity.setId(id);
        when(songRepository.findById(id)).thenReturn(Optional.of(songEntity));

        // Calling the method
        GetSongByIdResponse response = getSongByIdUseCaseService.getSongById(id);

        // Verifying the result
        assertNotNull(response);
        assertNotNull(response.getSong());
        assertEquals(songEntity.getId(), response.getSong().getId());
    }

    @Test
    void testGetSongByIdNotFound() {
        // Mocking data
        long id = 2L;
        when(songRepository.findById(id)).thenReturn(Optional.empty());

        // Calling the method and expecting an exception
        assertThrows(NoSuchElementException.class, () -> getSongByIdUseCaseService.getSongById(id));
    }
}
