package com.csc340.StudySpace.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.csc340.StudySpace.dto.ReviewDTO;
import com.csc340.StudySpace.entity.Customer;
import com.csc340.StudySpace.entity.Review;
import com.csc340.StudySpace.repository.CustomerRepository;
import com.csc340.StudySpace.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;

    public ReviewService(ReviewRepository reviewRepository, CustomerRepository customerRepository) {
        this.reviewRepository = reviewRepository;
        this.customerRepository = customerRepository;
    }

    // --- CRUD methods ---
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

    // --- Additional GET endpoints ---
    public List<Review> getReviewsByCustomerId(Long customerId) {
        return reviewRepository.findByCustomerId(customerId);
    }

    public List<Review> getReviewsByAppointmentId(Long appointmentId) {
        return reviewRepository.findByAppointmentId(appointmentId);
    }

    // --- Provider-specific: get reviews with student names (DTO) ---
    public List<ReviewDTO> getReviewsByTutorName(String tutorName) {
        List<Review> reviews = reviewRepository.findByTutorName(tutorName);
        return reviews.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ReviewDTO convertToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setCustomerId(review.getCustomerId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setReply(review.getReply());
        dto.setRepliedAt(review.getRepliedAt());

        // Fetch customer name
        if (review.getCustomerId() != null) {
            Optional<Customer> customer = customerRepository.findById(review.getCustomerId());
            dto.setStudentName(customer.map(Customer::getName).orElse("Anonymous"));
        } else {
            dto.setStudentName("Anonymous");
        }

        // Set course (default for now; can be fetched from appointment later)
        dto.setCourse("General");
        return dto;
    }

    // --- Reply methods ---
    public Review replyToReview(Long id, String reply) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        review.setReply(reply);
        review.setRepliedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    public Review deleteReply(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        review.setReply(null);
        review.setRepliedAt(null);
        return reviewRepository.save(review);
    }
}