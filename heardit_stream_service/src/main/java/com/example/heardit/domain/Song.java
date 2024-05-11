package com.example.heardit.domain;

import lombok.*;

@Generated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private Long id;
    private String nametrack;
    private byte[] filetrack;
}
