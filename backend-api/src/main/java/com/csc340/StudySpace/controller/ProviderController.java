package com.csc340.StudySpace.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.StudySpace.entity.Provider;
import com.csc340.StudySpace.entity.TutoringService;
import com.csc340.StudySpace.service.ProviderService;
import com.csc340.StudySpace.service.TutoringServiceManager;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    private final ProviderService providerService;
    private final TutoringServiceManager tutoringServiceManager;

    public ProviderController(ProviderService providerService,
                              TutoringServiceManager tutoringServiceManager) {
        this.providerService = providerService;
        this.tutoringServiceManager = tutoringServiceManager;
    }

    //Provider Profile 
    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Provider> getProviderByEmail(@PathVariable String email) {
        Provider provider = providerService.findByEmail(email);
        return provider != null ? ResponseEntity.ok(provider) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders() {
        List<Provider> providers = providerService.getAllProviders();
        return providers.isEmpty() ? ResponseEntity.ok(Collections.emptyList()) : ResponseEntity.ok(providers);
    }

    @PostMapping
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        Provider created = providerService.createProvider(provider);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable Long id,
                                                   @RequestBody Provider updatedProvider) {
        try {
            Provider provider = providerService.updateProvider(id, updatedProvider);
            return ResponseEntity.ok(provider);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<Provider> updateProfile(@PathVariable Long id,
                                                  @RequestBody Provider updatedProvider) {
        try {
            Provider provider = providerService.updateProfile(id, updatedProvider);
            return ResponseEntity.ok(provider);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Provider> updateAccountStatus(@PathVariable Long id,
                                                        @RequestBody Map<String, String> request) {
        try {
            Provider provider = providerService.updateAccountStatus(id, request.get("accountStatus"));
            return ResponseEntity.ok(provider);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return ResponseEntity.noContent().build();
    }

    //Services
    @GetMapping("/{providerId}/services")
    public ResponseEntity<List<TutoringService>> getServicesByProvider(@PathVariable Long providerId) {
        List<TutoringService> services = tutoringServiceManager.getServicesByProvider(providerId);
        return services.isEmpty() ? ResponseEntity.ok(Collections.emptyList()) : ResponseEntity.ok(services);
    }

    @PostMapping("/{providerId}/services")
    public ResponseEntity<TutoringService> createService(@PathVariable Long providerId,
                                                         @RequestBody TutoringService service) {
        service.setProviderId(providerId);
        TutoringService created = tutoringServiceManager.createService(service);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{providerId}/services/{serviceId}")
    public ResponseEntity<TutoringService> updateService(@PathVariable Long providerId,
                                                         @PathVariable Long serviceId,
                                                         @RequestBody TutoringService updatedService) {
        try {
            TutoringService existing = tutoringServiceManager.getServiceById(serviceId)
                    .orElseThrow(() -> new RuntimeException("Service not found"));
            if (!existing.getProviderId().equals(providerId)) {
                return ResponseEntity.badRequest().build();
            }
            TutoringService service = tutoringServiceManager.updateService(serviceId, updatedService);
            return ResponseEntity.ok(service);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{providerId}/services/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long providerId,
                                              @PathVariable Long serviceId) {
        try {
            TutoringService existing = tutoringServiceManager.getServiceById(serviceId)
                    .orElseThrow(() -> new RuntimeException("Service not found"));
            if (!existing.getProviderId().equals(providerId)) {
                return ResponseEntity.badRequest().build();
            }
            tutoringServiceManager.deleteService(serviceId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}