package com.csc340.StudySpace.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutoringService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String category;   
    private Integer duration;      

    @Column(nullable = false)
    private Long providerId;

    private String status = "ACTIVE";
    private LocalDate createdAt;

    public TutoringService(String name, String description, String category,
                            Integer duration, Long providerId) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.duration = duration;
        this.providerId = providerId;
        this.createdAt = LocalDate.now();
    }
}