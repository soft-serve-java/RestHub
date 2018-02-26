package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;



@Service
public interface ReviewService {
    Review create(Review review);

    Page<Review> findAllDesc(Integer pageNumber);

    Page<Review> findAllDescApproved(Integer pageNumber, Boolean approved);

    void tweakApproved(long id, boolean approved);
}
