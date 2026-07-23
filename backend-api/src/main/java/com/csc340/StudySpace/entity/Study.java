package com.csc340.StudySpace.entity;

import java.time.LocalDateTime;

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
@Table(name = "studies")   
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String subject;         

    private String description;

    private String link;            

    @Column(nullable = false)
    private String postedBy;         

    private LocalDateTime createdAt;

    public Study(String title, String subject, String description, String link, String postedBy) {
        this.title = title;
        this.subject = subject;
        this.description = description;
        this.link = link;
        this.postedBy = postedBy;
        this.createdAt = LocalDateTime.now();
    }
}