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
@Table(name = "providers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String accountStatus;   

    @Column(nullable = false)
    private String role = "PROVIDER";

    private String profileStatus = "APPROVED";

    private String bio;
    private String phone;
    private String major;
    private String academicLevel;
    private Integer yearsExperience;

    private LocalDate createdAt;

    public Provider(String name, String email, String password,
                    String accountStatus, String bio, String phone,
                    String major, String academicLevel, Integer yearsExperience) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
        this.bio = bio;
        this.phone = phone;
        this.major = major;
        this.academicLevel = academicLevel;
        this.yearsExperience = yearsExperience;
        this.createdAt = LocalDate.now();
    }
}