package com.csc340.StudySpace.repository;

import com.csc340.StudySpace.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findBySubject(String subject);

    List<Resource> findByTitleContainingIgnoreCase(String title);
}