package com.csc340.StudySpace.controller;

import com.csc340.StudySpace.entity.Appointment;
import com.csc340.StudySpace.entity.Customer;
import com.csc340.StudySpace.service.AppointmentService;
import com.csc340.StudySpace.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AppointmentMvcController {

    private final AppointmentService appointmentService;
    private final CustomerService customerService;

    public AppointmentMvcController(
            AppointmentService appointmentService,
            CustomerService customerService
    ) {
        this.appointmentService = appointmentService;
        this.customerService = customerService;
    }

    @GetMapping("/customer/appointments")
    public String showAppointments(
            @RequestParam(defaultValue = "1") Long customerId,
            Model model
    ) {

        Customer customer = customerService
                .getCustomerById(customerId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Customer not found with id: " + customerId
                        )
                );

        List<Appointment> appointments =
                appointmentService.getAppointmentsByCustomerId(customerId);

        long upcomingCount = appointments.stream()
                .filter(this::isUpcoming)
                .count();

        long completedCount = appointments.stream()
                .filter(appointment ->
                        hasStatus(appointment, "COMPLETED"))
                .count();

        long canceledCount = appointments.stream()
                .filter(appointment ->
                        hasStatus(appointment, "CANCELED")
                                || hasStatus(appointment, "CANCELLED"))
                .count();

        model.addAttribute("customer", customer);
        model.addAttribute("customerId", customerId);
        model.addAttribute("appointments", appointments);

        model.addAttribute("upcomingCount", upcomingCount);
        model.addAttribute("completedCount", completedCount);
        model.addAttribute("canceledCount", canceledCount);

        model.addAttribute("newAppointment", new Appointment());

        return "customer/appointments";
    }

    
    @PostMapping("/customer/appointments/book")
    public String bookAppointment(
            @RequestParam Long customerId,
            @ModelAttribute Appointment appointment,
            RedirectAttributes redirectAttributes
    ) {

        appointment.setCustomerId(customerId);

        if (appointment.getStatus() == null
                || appointment.getStatus().isBlank()) {
            appointment.setStatus("PENDING");
        }

        appointmentService.createAppointment(appointment);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Session request submitted successfully!"
        );

        return "redirect:/customer/appointments?customerId=" + customerId;
    }

    @PostMapping("/customer/appointments/cancel/{id}")
    public String cancelAppointment(
            @PathVariable Long id,
            @RequestParam Long customerId,
            RedirectAttributes redirectAttributes
    ) {

        appointmentService.cancelAppointment(id);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Appointment canceled successfully."
        );

        return "redirect:/customer/appointments?customerId=" + customerId;
    }

    private boolean isUpcoming(Appointment appointment) {
        return hasStatus(appointment, "PENDING")
                || hasStatus(appointment, "CONFIRMED")
                || hasStatus(appointment, "SCHEDULED");
    }

    private boolean hasStatus(
            Appointment appointment,
            String expectedStatus
    ) {
        return appointment.getStatus() != null
                && appointment.getStatus()
                .trim()
                .equalsIgnoreCase(expectedStatus);
    }
}