package com.csc340.StudySpace.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.StudySpace.repository.AppointmentRepository;
import com.csc340.StudySpace.repository.CustomerRepository;
import com.csc340.StudySpace.repository.ResourceRepository;
import com.csc340.StudySpace.repository.ReviewRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminStatisticsController {

    private final CustomerRepository customerRepository;
    private final ResourceRepository resourceRepository;
    private final ReviewRepository reviewRepository;
    private final AppointmentRepository appointmentRepository;

    public AdminStatisticsController(CustomerRepository customerRepository,
                                     ResourceRepository resourceRepository,
                                     ReviewRepository reviewRepository,
                                     AppointmentRepository appointmentRepository) {
        this.customerRepository = customerRepository;
        this.resourceRepository = resourceRepository;
        this.reviewRepository = reviewRepository;
        this.appointmentRepository = appointmentRepository;
    }

    // Admin use case: view basic usage statistics
    @GetMapping("/statistics")
    public Map<String, Long> getUsageStatistics() {
        Map<String, Long> statistics = new HashMap<>();

        statistics.put("totalCustomers", customerRepository.count());
        statistics.put("totalResources", resourceRepository.count());
        statistics.put("totalReviews", reviewRepository.count());
        statistics.put("totalAppointments", appointmentRepository.count());

        return statistics;
    }
}