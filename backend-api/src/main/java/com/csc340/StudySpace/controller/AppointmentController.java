package com.csc340.StudySpace.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.csc340.StudySpace.entity.Appointment;
import com.csc340.StudySpace.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();

        if (appointments.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.ok(createdAppointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id,
                                                         @RequestBody Appointment updatedAppointment) {
        try {
            Appointment appointment = appointmentService.updateAppointment(id, updatedAppointment);
            return ResponseEntity.ok(appointment);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByCustomerId(customerId));
    }

    @GetMapping("/course/{course}")
    public ResponseEntity<List<Appointment>> getAppointmentsByCourse(@PathVariable String course) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByCourse(course));
    }

    @GetMapping("/tutor/{tutorName}")
    public ResponseEntity<List<Appointment>> getAppointmentsByTutorName(@PathVariable String tutorName) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByTutorName(tutorName));
    }
}