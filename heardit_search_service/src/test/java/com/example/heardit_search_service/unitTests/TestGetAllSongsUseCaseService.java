package com.example.heardit_search_service.unitTests;

import com.example.heardit_search_service.data_access.SongRepository;
import com.example.heardit_search_service.domain.GetAllSongsRequest;
import com.example.heardit_search_service.domain.GetAllSongsResponse;
import com.example.heardit_search_service.domain.Song;
import com.example.heardit_search_service.service.GetAllSongsUseCaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestGetAllSongsUseCaseService {
    @Mock
    private SongRepository songRepository;

    @InjectMocks
    private GetAllSongsUseCaseService getAllSongsUseCaseService;

    @Test
    public void testGetAllSongs() {
        List<Object[]> mockedResults = new ArrayList<>();
        mockedResults.add(new Object[]{1L, "Song 1", "user@email.com"});
        mockedResults.add(new Object[]{2L, "Song 2", "user@email.com"});

        when(songRepository.findSongsByGivenParameters(anyString(),anyString())).thenReturn(mockedResults);

        GetAllSongsRequest request = new GetAllSongsRequest();
        request.setNametrack("Song");
        request.setUseremail("user@email.com");

        GetAllSongsResponse response = getAllSongsUseCaseService.getAllSongs(request);

        verify(songRepository).findSongsByGivenParameters("Song", "user@email.com");

        List<Song> songs = response.getSongs();

        assertEquals(2, songs.size());
        assertEquals(1L, songs.get(0).getId());
        assertEquals("Song 1", songs.get(0).getNametrack());
        assertEquals("user@email.com", songs.get(0).getUseremail());
        assertEquals(2L, songs.get(1).getId());
        assertEquals("Song 2", songs.get(1).getNametrack());
        assertEquals("user@email.com", songs.get(1).getUseremail());
    }
}
