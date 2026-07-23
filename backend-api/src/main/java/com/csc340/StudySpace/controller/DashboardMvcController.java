package com.csc340.StudySpace.controller;

import com.csc340.StudySpace.entity.Customer;
import com.csc340.StudySpace.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardMvcController {

    private final CustomerService customerService;

    public DashboardMvcController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/dashboard/{id}")
    public String showDashboard(@PathVariable Long id, Model model) {

        Customer customer = customerService.getCustomerById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found with id: " + id)
                );

        model.addAttribute("customer", customer);
        model.addAttribute("upcomingSessionCount", 0);
        model.addAttribute("savedResourceCount", 0);
        model.addAttribute("completedSessionCount", 0);
        model.addAttribute("reviewCount", 0);

        return "customer/dashboard";
    }
}