package com.csc340.StudySpace.service;

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
        Optional<Review> existingReview = reviewRepository.findById(id);

        if (existingReview.isPresent()) {
            Review review = existingReview.get();

            review.setCustomerId(updatedReview.getCustomerId());
            review.setAppointmentId(updatedReview.getAppointmentId());
            review.setTutorName(updatedReview.getTutorName());
            review.setRating(updatedReview.getRating());
            review.setComment(updatedReview.getComment());
            review.setStatus(updatedReview.getStatus());

            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Review not found with id: " + id);
        }
    }

    // Admin use case: update review moderation status
    public Review updateReviewStatus(Long id, String status) {
         Optional<Review> existingReview = reviewRepository.findById(id);

         if (existingReview.isPresent()) {
            Review review = existingReview.get();

            review.setStatus(status);

            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Review not found with id: " + id);
        }
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
}