package com.csc340.StudySpace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csc340.StudySpace.entity.Review;
import com.csc340.StudySpace.service.ReviewService;

@Controller
public class CustomerReviewMvcController {

    private final ReviewService reviewService;

    public CustomerReviewMvcController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/customer/reviews")
    public String showReviews(Model model) {

        model.addAttribute("reviews",
                reviewService.getReviewsByCustomerId(1L));

        model.addAttribute("newReview", new Review());

        return "customer/reviews";
    }

    @PostMapping("/customer/reviews")
    public String submitReview(
            @ModelAttribute("newReview") Review review) {

        review.setCustomerId(1L);
        review.setStatus("SUBMITTED");

        reviewService.createReview(review);

        return "redirect:/customer/reviews";
    }
}