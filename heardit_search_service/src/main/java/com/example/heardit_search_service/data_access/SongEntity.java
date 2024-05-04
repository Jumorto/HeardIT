package com.example.heardit_search_service.data_access;

import jakarta.persistence.*;
import lombok.*;

@Generated
@Entity
@Table(name = "tracks")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nametrack")
    private String nametrack;

    @Column(name = "filetrack")
    private byte[] filetrack;
}
