package com.csc340.StudySpace.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csc340.StudySpace.entity.Study;
import com.csc340.StudySpace.repository.StudyRepository;

@Service
public class StudyService {

    private final StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public List<Study> getAllStudies() {
        return studyRepository.findAll();
    }

    public Optional<Study> getStudyById(Long id) {
        return studyRepository.findById(id);
    }

    public Study createStudy(Study study) {
        study.setCreatedAt(LocalDateTime.now());
        return studyRepository.save(study);
    }

    public Study updateStudy(Long id, Study updatedStudy) {
        Study existing = studyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        existing.setTitle(updatedStudy.getTitle());
        existing.setSubject(updatedStudy.getSubject());
        existing.setDescription(updatedStudy.getDescription());
        existing.setLink(updatedStudy.getLink());
        existing.setPostedBy(updatedStudy.getPostedBy());
        return studyRepository.save(existing);
    }

    public void deleteStudy(Long id) {
        studyRepository.deleteById(id);
    }

    public List<Study> searchBySubject(String subject) {
        return studyRepository.findBySubjectContainingIgnoreCase(subject);
    }

    public List<Study> searchByTitle(String title) {
        return studyRepository.findByTitleContainingIgnoreCase(title);
    }
}