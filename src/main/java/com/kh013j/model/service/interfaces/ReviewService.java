package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ReviewService {
    Review create(Review review);

    List<Review> findAllDesc();

    Review tweakApproved(long id, boolean approved);
}
