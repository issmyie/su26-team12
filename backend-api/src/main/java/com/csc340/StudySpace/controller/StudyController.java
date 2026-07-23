package com.csc340.StudySpace.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.StudySpace.entity.Study;
import com.csc340.StudySpace.service.StudyService;

@RestController
@RequestMapping("/api/studies")
@CrossOrigin(origins = "*")
public class StudyController {

    private final StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping
    public ResponseEntity<List<Study>> getAllStudies() {
        List<Study> studies = studyService.getAllStudies();
        return studies.isEmpty() ? ResponseEntity.ok(Collections.emptyList()) : ResponseEntity.ok(studies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Study> getStudyById(@PathVariable Long id) {
        return studyService.getStudyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Study> createStudy(@RequestBody Study study) {
        Study created = studyService.createStudy(study);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Study> updateStudy(@PathVariable Long id,
                                             @RequestBody Study updatedStudy) {
        try {
            Study study = studyService.updateStudy(id, updatedStudy);
            return ResponseEntity.ok(study);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudy(@PathVariable Long id) {
        studyService.deleteStudy(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Study>> searchStudies(@RequestParam(required = false) String title,
                                                     @RequestParam(required = false) String subject) {
        if (title != null && !title.isEmpty()) {
            return ResponseEntity.ok(studyService.searchByTitle(title));
        } else if (subject != null && !subject.isEmpty()) {
            return ResponseEntity.ok(studyService.searchBySubject(subject));
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
}