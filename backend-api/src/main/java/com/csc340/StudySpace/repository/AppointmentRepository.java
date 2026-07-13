package com.csc340.StudySpace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csc340.StudySpace.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByCustomerId(Long customerId);
    List<Appointment> findByCourse(String course);
    List<Appointment> findByTutorName(String tutorName);

    @Query("SELECT a.course, COUNT(a) FROM Appointment a WHERE a.tutorName = :tutorName GROUP BY a.course")
    List<Object[]> countAppointmentsByTutorGroupedByCourse(@Param("tutorName") String tutorName);
}