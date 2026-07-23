package com.csc340.StudySpace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.csc340.StudySpace.entity.Customer;
import com.csc340.StudySpace.service.CustomerService;

@Controller
public class CustomerMvcController {

    private final CustomerService customerService;

    public CustomerMvcController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/register";
    }

    @PostMapping("/customer/register")
    public String registerCustomer(@ModelAttribute Customer customer) {
        customer.setAccountStatus("ACTIVE");
        customer.setRole("CUSTOMER");
        customer.setProfileStatus("APPROVED");

        Customer savedCustomer = customerService.createCustomer(customer);

        return "redirect:/customer/profile/" + savedCustomer.getId();
    }

    @GetMapping("/customer/profile/{id}")
    public String showProfile(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found with id: " + id));

        model.addAttribute("customer", customer);
        return "customer/profile";
    }

    @PostMapping("/customer/profile/{id}/update")
    public String updateProfile(
            @PathVariable Long id,
            @ModelAttribute Customer updatedCustomer) {

        customerService.updateProfile(id, updatedCustomer);

        return "redirect:/customer/profile/" + id;
    }

}