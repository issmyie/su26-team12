package com.csc340.StudySpace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csc340.StudySpace.entity.Provider;
import com.csc340.StudySpace.repository.ProviderRepository;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Optional<Provider> getProviderById(Long id) {
        return providerRepository.findById(id);
    }

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider updateProvider(Long id, Provider updatedProvider) {
        Provider existing = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        existing.setName(updatedProvider.getName());
        existing.setEmail(updatedProvider.getEmail());
        existing.setPassword(updatedProvider.getPassword());
        existing.setAccountStatus(updatedProvider.getAccountStatus());
        existing.setBio(updatedProvider.getBio());
        existing.setPhone(updatedProvider.getPhone());
        existing.setMajor(updatedProvider.getMajor());
        existing.setAcademicLevel(updatedProvider.getAcademicLevel());
        existing.setYearsExperience(updatedProvider.getYearsExperience());
        return providerRepository.save(existing);
    }

    public Provider updateProfile(Long id, Provider updatedProvider) {
        Provider existing = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        if (updatedProvider.getName() != null) existing.setName(updatedProvider.getName());
        if (updatedProvider.getEmail() != null) existing.setEmail(updatedProvider.getEmail());
        if (updatedProvider.getBio() != null) existing.setBio(updatedProvider.getBio());
        if (updatedProvider.getPhone() != null) existing.setPhone(updatedProvider.getPhone());
        if (updatedProvider.getMajor() != null) existing.setMajor(updatedProvider.getMajor());
        if (updatedProvider.getAcademicLevel() != null) existing.setAcademicLevel(updatedProvider.getAcademicLevel());
        if (updatedProvider.getYearsExperience() != null) existing.setYearsExperience(updatedProvider.getYearsExperience());
        return providerRepository.save(existing);
    }

    public Provider updateAccountStatus(Long id, String accountStatus) {
        Provider existing = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        existing.setAccountStatus(accountStatus);
        return providerRepository.save(existing);
    }

    // Admin use case: moderate provider profile
    public Provider updateProfileStatus(Long id, String profileStatus) {

        Provider existing = providerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Provider not found"));

        existing.setProfileStatus(profileStatus);
        return providerRepository.save(existing);
}

    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }

    public Provider findByEmail(String email) {
        return providerRepository.findByEmail(email).orElse(null);
    }

    public Provider updateRole(Long id, String role) {

    Provider provider = providerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Provider not found"));

    provider.setRole(role);

    return providerRepository.save(provider);
}
}