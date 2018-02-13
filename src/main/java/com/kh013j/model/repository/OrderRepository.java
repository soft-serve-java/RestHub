package com.kh013j.model.repository;

import com.kh013j.model.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public Order findFirstByTablenumberAndCloseFalse(int tablenumber);
}