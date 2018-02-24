package com.kh013j.model.service;

import com.kh013j.model.domain.Review;
import com.kh013j.model.repository.ReviewRepository;
import com.kh013j.model.service.interfaces.ReviewService;

import javax.annotation.Resource;

public class ReviewServiceImpl implements ReviewService {

    @Resource
    ReviewRepository reviewRepository;

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }
}
