package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Review;
import org.springframework.stereotype.Service;


@Service
public interface ReviewService {

    Review create(Review review);
}
