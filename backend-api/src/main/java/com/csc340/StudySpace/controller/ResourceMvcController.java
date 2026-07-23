package com.csc340.StudySpace.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csc340.StudySpace.entity.Resource;
import com.csc340.StudySpace.service.ResourceService;

@Controller
public class ResourceMvcController {

    private final ResourceService resourceService;

    public ResourceMvcController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/customer/resources")
    public String showResources(
            @RequestParam(required = false) String title,
            Model model) {

        List<Resource> resources;

        if (title != null && !title.isBlank()) {
            resources = resourceService.searchResourcesByTitle(title);
        } else {
            resources = resourceService.getVisibleResources();
        }

        long subjectCount = resources.stream()
                .map(resource -> resource.getSubject())
                .filter(subject -> subject != null && !subject.isBlank())
                .distinct()
                .count();

        model.addAttribute("resources", resources);
        model.addAttribute("searchTitle", title);
        model.addAttribute("subjectCount", subjectCount);

        return "customer/resources";
    }
}