package com.kh013j.model.repository;


import com.kh013j.model.domain.Review;
import com.kh013j.model.domain.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByDishAndApprovedTrue(Dish dish);

    Page<Review> findAllByOrderByIdDesc(Pageable pageable);

    Page<Review> findAllByApprovedOrderByIdDesc(Boolean approved, Pageable pageable);
}
