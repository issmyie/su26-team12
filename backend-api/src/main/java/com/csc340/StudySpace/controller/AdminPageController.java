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
import com.csc340.StudySpace.entity.Customer;
import com.csc340.StudySpace.entity.Provider;
import com.csc340.StudySpace.service.CustomerService;
import com.csc340.StudySpace.service.ProviderService;
import com.csc340.StudySpace.service.ReviewService;

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
    private final CustomerService customerService;
    private final ProviderService providerService;
    private final ReviewService reviewService;

    public AdminPageController(CustomerRepository customerRepository, ResourceRepository resourceRepository, ReviewRepository reviewRepository, AppointmentRepository appointmentRepository, ResourceService resourceService, CustomerService customerService, ProviderService providerService, ReviewService reviewService){
        this.customerRepository = customerRepository;
        this.resourceRepository = resourceRepository;
        this.reviewRepository = reviewRepository;
        this.appointmentRepository = appointmentRepository;
        this.resourceService = resourceService;
        this.customerService = customerService;
        this.providerService = providerService;
        this.reviewService = reviewService;

    }

    @GetMapping("/admin/statistics")
public String showStatistics(Model model) {

    model.addAttribute("totalCustomers", customerRepository.count());
    model.addAttribute("totalResources", resourceRepository.count());
    model.addAttribute("totalReviews", reviewRepository.count());
    model.addAttribute("totalAppointments", appointmentRepository.count());

    return "admin-statistics";
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

    @GetMapping("/admin/users")
    public String showUsers(Model model) {

    List<Customer> customers = customerService.getAllCustomers();
    List<Provider> providers = providerService.getAllProviders();

    model.addAttribute("customers", customers);
    model.addAttribute("providers", providers);

    return "admin-users";
}

    @PostMapping("/admin/users/customer/{id}/enable")
    public String enableCustomer(@PathVariable Long id) {
    customerService.updateAccountStatus(id, "ACTIVE");
    return "redirect:/admin/users";
}

    @PostMapping("/admin/users/customer/{id}/disable")
    public String disableCustomer(@PathVariable Long id) {
    customerService.updateAccountStatus(id, "DISABLED");
    return "redirect:/admin/users";
}

    @PostMapping("/admin/users/provider/{id}/enable")
    public String enableProvider(@PathVariable Long id) {
    providerService.updateAccountStatus(id, "ACTIVE");
    return "redirect:/admin/users";
}

    @PostMapping("/admin/users/provider/{id}/disable")
    public String disableProvider(@PathVariable Long id) {
    providerService.updateAccountStatus(id, "DISABLED");
    return "redirect:/admin/users";
}
// Give Customer Admin Access
@PostMapping("/admin/users/customers/{id}/make-admin")
public String makeCustomerAdmin(@PathVariable Long id) {

    customerService.updateRole(id, "ADMIN");

    return "redirect:/admin/users";
}

// Remove Customer Admin Access
@PostMapping("/admin/users/customers/{id}/remove-admin")
public String removeCustomerAdmin(@PathVariable Long id) {

    customerService.updateRole(id, "CUSTOMER");

    return "redirect:/admin/users";
}

// Give Provider Admin Access
@PostMapping("/admin/users/providers/{id}/make-admin")
public String makeProviderAdmin(@PathVariable Long id) {

    providerService.updateRole(id, "ADMIN");

    return "redirect:/admin/users";
}

// Remove Provider Admin Access
@PostMapping("/admin/users/providers/{id}/remove-admin")
public String removeProviderAdmin(@PathVariable Long id) {

    providerService.updateRole(id, "PROVIDER");

    return "redirect:/admin/users";
}

@GetMapping("/admin/profiles")
public String showProfiles(Model model) {

    model.addAttribute("providers", providerService.getAllProviders());

    return "admin-profiles";
}

@PostMapping("/admin/profiles/{id}/approve")
public String approveProfile(@PathVariable Long id) {

    providerService.updateProfileStatus(id, "APPROVED");

    return "redirect:/admin/profiles";
}

@PostMapping("/admin/profiles/{id}/reject")
public String rejectProfile(@PathVariable Long id) {

    providerService.updateProfileStatus(id, "REJECTED");

    return "redirect:/admin/profiles";
}
    //Loads all resources so the admin can review it
    @GetMapping("/admin/resources")
    public String showResources(Model model) {
        List<Resource> resources = resourceService.getAllResources();
        model.addAttribute("resources", resources);

        return "admin-resources";
    }    

    @GetMapping("/admin/reviews")
public String showReviews(Model model) {

    model.addAttribute("reviews", reviewService.getAllReviews());

    return "admin-reviews";
}

@PostMapping("/admin/reviews/{id}/show")
public String showReview(@PathVariable Long id) {

    reviewService.updateReviewStatus(id, "VISIBLE");

    return "redirect:/admin/reviews";
}

@PostMapping("/admin/reviews/{id}/hide")
public String hideReview(@PathVariable Long id) {

    reviewService.updateReviewStatus(id, "HIDDEN");

    return "redirect:/admin/reviews";
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

    @GetMapping("/logout")
public String logout() {
    return "redirect:/login";
}
}
