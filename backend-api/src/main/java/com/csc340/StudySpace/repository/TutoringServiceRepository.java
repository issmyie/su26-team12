package com.csc340.StudySpace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc340.StudySpace.entity.TutoringService;

public interface TutoringServiceRepository extends JpaRepository<TutoringService, Long> {
    List<TutoringService> findByProviderId(Long providerId);
}