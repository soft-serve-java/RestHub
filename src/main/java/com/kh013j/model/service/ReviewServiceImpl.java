package com.kh013j.model.service;

import com.kh013j.model.domain.Review;
import com.kh013j.model.repository.ReviewRepository;
import com.kh013j.model.service.interfaces.ReviewService;

import javax.annotation.Resource;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Resource
    private ReviewRepository reviewRepository;

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllDesc() {
        return reviewRepository.findAllByOrderByIdDesc();
    }

    @Override
    public void tweakApproved(long id, boolean approved) {
        Review review = reviewRepository.findOne(id);
        if (review.getApproved() == null){
            review.setApproved(approved);
        } else {
            review.setApproved(!review.getApproved());
        }
        reviewRepository.save(review);
    }
}
