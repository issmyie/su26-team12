package com.csc340.StudySpace.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csc340.StudySpace.entity.TutoringService;
import com.csc340.StudySpace.repository.TutoringServiceRepository;

@Service
public class TutoringServiceManager {

    private final TutoringServiceRepository repository;

    public TutoringServiceManager(TutoringServiceRepository repository) {
        this.repository = repository;
    }

    public List<TutoringService> getServicesByProvider(Long providerId) {
        return repository.findByProviderId(providerId);
    }

    public Optional<TutoringService> getServiceById(Long id) {
        return repository.findById(id);
    }

    public TutoringService createService(TutoringService service) {
        service.setCreatedAt(LocalDate.now());
        return repository.save(service);
    }

    public TutoringService updateService(Long id, TutoringService updatedService) {
        TutoringService existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        existing.setName(updatedService.getName());
        existing.setDescription(updatedService.getDescription());
        existing.setCategory(updatedService.getCategory());
        existing.setDuration(updatedService.getDuration());
        existing.setStatus(updatedService.getStatus());
        return repository.save(existing);
    }

    public void deleteService(Long id) {
        repository.deleteById(id);
    }
}