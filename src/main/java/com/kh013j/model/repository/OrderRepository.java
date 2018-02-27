package com.kh013j.model.repository;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findFirstByTablenumberAndClosedFalse(int tablenumber);
    List<Order> findAllByClosedFalse();
}