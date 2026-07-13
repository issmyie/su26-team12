package com.csc340.StudySpace.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.StudySpace.entity.Provider;
import com.csc340.StudySpace.entity.TutoringService;
import com.csc340.StudySpace.repository.AppointmentRepository;
import com.csc340.StudySpace.service.ProviderService;
import com.csc340.StudySpace.service.TutoringServiceManager;

@RestController
@RequestMapping("/api/providers")
public class ProviderStatisticsController {

    private final ProviderService providerService;
    private final TutoringServiceManager tutoringServiceManager;
    private final AppointmentRepository appointmentRepository;

    public ProviderStatisticsController(ProviderService providerService,
                                        TutoringServiceManager tutoringServiceManager,
                                        AppointmentRepository appointmentRepository) {
        this.providerService = providerService;
        this.tutoringServiceManager = tutoringServiceManager;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/{providerId}/statistics")
    public ResponseEntity<List<Map<String, Object>>> getProviderStatistics(@PathVariable Long providerId) {
        Provider provider = providerService.getProviderById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        List<TutoringService> services = tutoringServiceManager.getServicesByProvider(providerId);

        List<Object[]> rawCounts = appointmentRepository.countAppointmentsByTutorGroupedByCourse(provider.getName());
        Map<String, Long> courseCountMap = new HashMap<>();
        for (Object[] row : rawCounts) {
            String course = (String) row[0];
            Long count = (Long) row[1];
            courseCountMap.put(course, count);
        }

        List<Map<String, Object>> stats = new ArrayList<>();
        for (TutoringService service : services) {
            Long bookings = courseCountMap.getOrDefault(service.getName(), 0L);

            Map<String, Object> stat = new HashMap<>();
            stat.put("serviceId", service.getId());
            stat.put("serviceName", service.getName());
            stat.put("bookings", bookings);
            stats.add(stat);
        }

        return ResponseEntity.ok(stats);
    }
}