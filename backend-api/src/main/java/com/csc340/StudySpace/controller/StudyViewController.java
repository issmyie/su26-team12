package com.csc340.StudySpace.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.csc340.StudySpace.entity.Study;
import com.csc340.StudySpace.service.StudyService;


//adjust with log-in

@Controller
public class StudyViewController {

    private final StudyService studyService;

    public StudyViewController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping("/study-resources")
    public String studyResources(Model model) {
        List<Study> studies = studyService.getAllStudies();
        model.addAttribute("studies", studies);
      
        model.addAttribute("isTutor", true); // Hardcoded for demo; replace with actual logic
        return "study-resources"; 
    }
}