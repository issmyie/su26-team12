package com.csc340.StudySpace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc340.StudySpace.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Optional<Provider> findByEmail(String email);
}