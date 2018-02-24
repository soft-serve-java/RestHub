package com.kh013j.model.repository;


import com.kh013j.model.domain.Review;
import com.kh013j.model.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByDishAndApproved(Dish dish, boolean approved);

    List<Review> findAllByOrderByIdDesc();
}
