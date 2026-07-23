package com.csc340.StudySpace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.csc340.StudySpace.repository.AppointmentRepository;
import com.csc340.StudySpace.repository.CustomerRepository;
import com.csc340.StudySpace.repository.ResourceRepository;
import com.csc340.StudySpace.repository.ReviewRepository;
import com.csc340.StudySpace.entity.Resource;
import com.csc340.StudySpace.service.ResourceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


//MVC controllers used to displat system admin dashboard page
@Controller
public class AdminPageController {


    //Repositories are used to read current totals from the database
    private final CustomerRepository customerRepository;
    private final ResourceRepository resourceRepository;
    private final ReviewRepository reviewRepository;
    private final AppointmentRepository appointmentRepository;
    private final ResourceService resourceService;

    public AdminPageController(CustomerRepository customerRepository, ResourceRepository resourceRepository, ReviewRepository reviewRepository, AppointmentRepository appointmentRepository, ResourceService resourceService){
        this.customerRepository = customerRepository;
        this.resourceRepository = resourceRepository;
        this.reviewRepository = reviewRepository;
        this.appointmentRepository = appointmentRepository;
        this.resourceService = resourceService;

    }
    
//Loads the admin dashboard when teh user visits /admin
    @GetMapping("/admin")
    public String showAdminDashboard(Model model) {

        //Add live database counts to the model for freemarker fisplay
        model.addAttribute("totalCustomers", customerRepository.count());
        model.addAttribute("totalResources", resourceRepository.count());
        model.addAttribute("totalReviews", reviewRepository.count());
        model.addAttribute("totalAppointments", appointmentRepository.count());

        //Loads templates /admin-dashboard.ftlh
        return "admin-dashboard";
    }

    //Loads all resources so the admin can review it
    @GetMapping("/admin/resources")
    public String showResources(Model model) {
        List<Resource> resources = resourceService.getAllResources();
        model.addAttribute("resources", resources);

        return "admin-resources";
    }    

    //Approves a resource and saved the new status]
    @PostMapping("/admin/resources/{id}/approve")
    public String approveResource(@PathVariable Long id){
        resourceService.updateResourceStatus(id, "APPROVED");

        return "redirect:/admin/resources";
    }
    
    //Removes a resource and saves the new status
    @PostMapping("/admin/resources/{id}/remove")
    public String removeResource(@PathVariable Long id){
        resourceService.updateResourceStatus(id, "REMOVED");

        return "redirect:/admin/resources";
    }
}
