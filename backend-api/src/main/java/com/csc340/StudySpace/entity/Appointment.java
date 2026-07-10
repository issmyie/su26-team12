package com.csc340.StudySpace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String tutorName;

    @Column(nullable = false)
    private String appointmentDate;

    @Column(nullable = false)
    private String appointmentTime;

    private String status;

    private String notes;
}