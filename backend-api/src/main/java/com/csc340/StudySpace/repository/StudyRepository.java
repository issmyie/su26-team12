package com.csc340.StudySpace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csc340.StudySpace.entity.Study;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {
    List<Study> findBySubjectContainingIgnoreCase(String subject);
    List<Study> findByTitleContainingIgnoreCase(String title);
}