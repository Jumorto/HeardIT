package com.example.heardit_search_service.domain;

import lombok.*;

import java.util.List;

@Generated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSongsResponse {
    private List<Song> songs;
}
