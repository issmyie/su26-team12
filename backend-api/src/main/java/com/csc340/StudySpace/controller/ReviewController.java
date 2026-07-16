package com.csc340.StudySpace.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.StudySpace.dto.ReviewDTO;
import com.csc340.StudySpace.entity.Review;
import com.csc340.StudySpace.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // ... (all other endpoints as before) ...

    @GetMapping("/tutor/{tutorName}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByTutorName(@PathVariable String tutorName) {
        List<ReviewDTO> reviews = reviewService.getReviewsByTutorName(tutorName);
        return reviews.isEmpty() ? ResponseEntity.ok(Collections.emptyList()) : ResponseEntity.ok(reviews);
    }

    @PutMapping("/{id}/reply")
    public ResponseEntity<Review> replyToReview(@PathVariable Long id,
                                                @RequestBody Map<String, String> request) {
        try {
            Review review = reviewService.replyToReview(id, request.get("reply"));
            return ResponseEntity.ok(review);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/reply")
    public ResponseEntity<Review> deleteReply(@PathVariable Long id) {
        try {
            Review review = reviewService.deleteReply(id);
            return ResponseEntity.ok(review);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}