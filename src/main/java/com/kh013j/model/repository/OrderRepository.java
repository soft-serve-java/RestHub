package com.kh013j.model.repository;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
public Order findFirstByTablenumberAndCloseFalse(int tablenumber);
}