package com.kh013j.model.repository;

import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedDishRepository extends JpaRepository<OrderedDish, Long> {
    public List<OrderedDish> findAllByStatusIn(List<Status> statuses);
}
