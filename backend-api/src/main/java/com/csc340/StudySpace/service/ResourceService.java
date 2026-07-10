package com.csc340.StudySpace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csc340.StudySpace.entity.Resource;
import com.csc340.StudySpace.repository.ResourceRepository;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Optional<Resource> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Resource updateResource(Long id, Resource updatedResource) {
        Optional<Resource> existingResource = resourceRepository.findById(id);

        if (existingResource.isPresent()) {
            Resource resource = existingResource.get();

            resource.setTitle(updatedResource.getTitle());
            resource.setSubject(updatedResource.getSubject());
            resource.setDescription(updatedResource.getDescription());
            resource.setCategory(updatedResource.getCategory());
            resource.setResourceType(updatedResource.getResourceType());

            return resourceRepository.save(resource);
        } else {
            throw new RuntimeException("Resource not found with id: " + id);
        }
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    public List<Resource> getResourcesBySubject(String subject) {
        return resourceRepository.findBySubject(subject);
    }

    public List<Resource> searchResourcesByTitle(String title) {
        return resourceRepository.findByTitleContainingIgnoreCase(title);
    }
}