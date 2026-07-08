package com.csc340.StudySpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc340.StudySpace.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

}