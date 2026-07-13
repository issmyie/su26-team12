package com.csc340.StudySpace.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csc340.StudySpace.entity.Review;
import com.csc340.StudySpace.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Review existing = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        existing.setCustomerId(updatedReview.getCustomerId());
        existing.setAppointmentId(updatedReview.getAppointmentId());
        existing.setTutorName(updatedReview.getTutorName());
        existing.setRating(updatedReview.getRating());
        existing.setComment(updatedReview.getComment());
        existing.setStatus(updatedReview.getStatus());
        return reviewRepository.save(existing);
    }

    public Review updateReviewStatus(Long id, String status) {
        Review existing = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        existing.setStatus(status);
        return reviewRepository.save(existing);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> getReviewsByCustomerId(Long customerId) {
        return reviewRepository.findByCustomerId(customerId);
    }

    public List<Review> getReviewsByAppointmentId(Long appointmentId) {
        return reviewRepository.findByAppointmentId(appointmentId);
    }

    public List<Review> getReviewsByTutorName(String tutorName) {
        return reviewRepository.findByTutorName(tutorName);
    }

    // Provider use case: reply to a review
    public Review replyToReview(Long id, String reply) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        review.setReply(reply);
        review.setRepliedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }
}
