package com.example.heardit_songmanager_service.data_access;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SongRepository extends JpaRepository<SongEntity, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM SongEntity tr WHERE tr.useremail = :useremail AND (tr.id > 0)")
    void deleteAllByUserEmail(@Param("useremail") String useremail);
}