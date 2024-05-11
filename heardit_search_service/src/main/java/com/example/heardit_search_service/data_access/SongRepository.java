package com.example.heardit_search_service.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SongRepository extends JpaRepository<SongEntity, Long> {
    @Query("SELECT tr.id, tr.nametrack FROM SongEntity tr WHERE (:nametrack IS NULL OR tr.nametrack LIKE CONCAT('%', :nametrack, '%'))")
    List<Object[]> findSongsByGivenParameters(@Param("nametrack") String nametrack);
}