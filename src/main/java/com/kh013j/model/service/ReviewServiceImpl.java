package com.kh013j.model.service;

import com.kh013j.model.domain.Review;
import com.kh013j.model.repository.ReviewRepository;
import com.kh013j.model.service.interfaces.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

public class ReviewServiceImpl implements ReviewService {

    @Resource
    private ReviewRepository reviewRepository;

    private static final int PAGE_SIZE = 10;

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }


    @Override
    public Page<Review> findAllDesc(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return reviewRepository.findAllByOrderByIdDesc(request);
    }

    @Override
    public Page<Review> findAllDescApproved(Integer pageNumber, Boolean approved) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return reviewRepository.findAllByApprovedOrderByIdDesc(approved, request);
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
