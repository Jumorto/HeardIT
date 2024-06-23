package com.example.heardit_commentmanager_service.data_access;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM CommentEntity sc WHERE sc.useremail = :useremail AND (sc.id > 0)")
    void deleteAllByUserEmail(@Param("useremail") String useremail);

    @Query("SELECT sc.id, sc.useremail, sc.idsong, sc.commenttext, sc.commentdate FROM CommentEntity sc WHERE sc.idsong = :idsong")
    List<Object[]> findCommentsBySongId(@Param("idsong") Long idsong);
}