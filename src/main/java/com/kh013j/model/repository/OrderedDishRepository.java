package com.kh013j.model.repository;

import com.kh013j.model.domain.OrderedDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedDishRepository extends JpaRepository<OrderedDish, Long> {
}
