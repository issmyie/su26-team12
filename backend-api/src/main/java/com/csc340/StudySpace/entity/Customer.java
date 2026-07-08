package com.csc340.StudySpace.entity;

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
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String accountStatus;

    private String major;

    private String academicLevel;

    private String preferredStudyTime;

    public Customer(String name,
                    String email,
                    String phoneNumber,
                    String password,
                    String accountStatus,
                    String major,
                    String academicLevel,
                    String preferredStudyTime) {

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.accountStatus = accountStatus;
        this.major = major;
        this.academicLevel = academicLevel;
        this.preferredStudyTime = preferredStudyTime;
    }
}