package com.csc340.StudySpace.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.csc340.StudySpace.entity.Review;
import com.csc340.StudySpace.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();

        if (reviews.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.ok(createdReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id,
                                               @RequestBody Review updatedReview) {
        try {
            Review review = reviewService.updateReview(id, updatedReview);
            return ResponseEntity.ok(review);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Review>> getReviewsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(reviewService.getReviewsByCustomerId(customerId));
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<List<Review>> getReviewsByAppointmentId(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(reviewService.getReviewsByAppointmentId(appointmentId));
    }

    @GetMapping("/tutor/{tutorName}")
    public ResponseEntity<List<Review>> getReviewsByTutorName(@PathVariable String tutorName) {
        return ResponseEntity.ok(reviewService.getReviewsByTutorName(tutorName));
    }
}