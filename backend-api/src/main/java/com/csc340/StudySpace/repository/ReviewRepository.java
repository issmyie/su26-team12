package com.csc340.StudySpace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc340.StudySpace.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCustomerId(Long customerId);

    List<Review> findByAppointmentId(Long appointmentId);

    List<Review> findByTutorName(String tutorName);
}