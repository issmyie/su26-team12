package com.csc340.StudySpace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csc340.StudySpace.entity.Customer;
import com.csc340.StudySpace.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Create customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update all customer information
    public Customer updateCustomer(Long id, Customer updatedCustomer) {

        Optional<Customer> existingCustomer = customerRepository.findById(id);

        if (existingCustomer.isPresent()) {

            Customer customer = existingCustomer.get();

            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPassword(updatedCustomer.getPassword());
            customer.setAccountStatus(updatedCustomer.getAccountStatus());
            customer.setMajor(updatedCustomer.getMajor());
            customer.setAcademicLevel(updatedCustomer.getAcademicLevel());
            customer.setPreferredStudyTime(updatedCustomer.getPreferredStudyTime());

            return customerRepository.save(customer);

        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    // Update only profile information
    public Customer updateProfile(Long id, Customer updatedCustomer) {

        Optional<Customer> existingCustomer = customerRepository.findById(id);

        if (existingCustomer.isPresent()) {

            Customer customer = existingCustomer.get();

            if (updatedCustomer.getName() != null) {
                customer.setName(updatedCustomer.getName());
            }

            if (updatedCustomer.getEmail() != null) {
                customer.setEmail(updatedCustomer.getEmail());
            }

            if (updatedCustomer.getMajor() != null) {
                customer.setMajor(updatedCustomer.getMajor());
            }

            if (updatedCustomer.getAcademicLevel() != null) {
                customer.setAcademicLevel(updatedCustomer.getAcademicLevel());
            }

            if (updatedCustomer.getPreferredStudyTime() != null) {
                customer.setPreferredStudyTime(updatedCustomer.getPreferredStudyTime());
            }

            return customerRepository.save(customer);

        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    // Delete customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Find customer by email
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

}