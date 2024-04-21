package com.example.heardit_songmanager_service.unitTests;

import com.example.heardit_songmanager_service.data_access.SongEntity;
import com.example.heardit_songmanager_service.data_access.SongRepository;
import com.example.heardit_songmanager_service.domain.CreateNewSongEntryRequest;
import com.example.heardit_songmanager_service.domain.CreateNewSongEntryResponse;
import com.example.heardit_songmanager_service.service.CreateNewSongEntryUseCaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@ActiveProfiles("test")
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestCreateNewSongEntryUseCaseService {
    @Mock
    private SongRepository songRepositoryMock;

    @InjectMocks
    private CreateNewSongEntryUseCaseService createNewSongEntryUseCaseService;

    @Test
    void createNewBrand() {
        SongEntity testSong = SongEntity.builder().id(null).nametrack("Song1").filetrack(null).build();
        SongEntity testSong1 = SongEntity.builder().id(1L).nametrack("Song1").filetrack(null).build();
        when(songRepositoryMock.save(testSong)).thenReturn(testSong1);

        CreateNewSongEntryRequest request = CreateNewSongEntryRequest.builder().nameTrack("Song1").fileTrack(null).build();
        CreateNewSongEntryResponse actualResponse = createNewSongEntryUseCaseService.createNewSongEntry(request);

        assertEquals(testSong1.getId(), actualResponse.getId());
        verify(songRepositoryMock).save(testSong);
    }
}
