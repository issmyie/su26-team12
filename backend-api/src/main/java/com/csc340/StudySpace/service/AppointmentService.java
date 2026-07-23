package com.csc340.StudySpace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csc340.StudySpace.entity.Appointment;
import com.csc340.StudySpace.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);

        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();

            appointment.setCustomerId(updatedAppointment.getCustomerId());
            appointment.setCourse(updatedAppointment.getCourse());
            appointment.setTutorName(updatedAppointment.getTutorName());
            appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
            appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
            appointment.setStatus(updatedAppointment.getStatus());
            appointment.setNotes(updatedAppointment.getNotes());

            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> getAppointmentsByCustomerId(Long customerId) {
        return appointmentRepository.findByCustomerId(customerId);
    }

    public List<Appointment> getAppointmentsByCourse(String course) {
        return appointmentRepository.findByCourse(course);
    }

    public List<Appointment> getAppointmentsByTutorName(String tutorName) {
        return appointmentRepository.findByTutorName(tutorName);
    }

    public Appointment cancelAppointment(Long id) {

    Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Appointment not found with id: " + id));

    appointment.setStatus("CANCELED");

    return appointmentRepository.save(appointment);
}

}