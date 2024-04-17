package com.example.heardit.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SongRepository extends JpaRepository<SongEntity, Long> {
    @Query("SELECT tr.id, tr.nametrack, tr.filetrack FROM SongEntity tr WHERE tr.id=:id")
    SongEntity findSongById(@Param("id") Long id);
}