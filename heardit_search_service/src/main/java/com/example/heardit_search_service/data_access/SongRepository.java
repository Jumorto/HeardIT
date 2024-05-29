package com.example.heardit_search_service.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SongRepository extends JpaRepository<SongEntity, Long> {
    @Query("SELECT tr.id, tr.nametrack, tr.useremail FROM SongEntity tr WHERE (:nametrack IS NULL OR tr.nametrack LIKE CONCAT('%', :nametrack, '%')) AND (:useremail IS NULL OR tr.useremail = :useremail)")
    List<Object[]> findSongsByGivenParameters(@Param("nametrack") String nametrack, @Param("useremail") String useremail);
}