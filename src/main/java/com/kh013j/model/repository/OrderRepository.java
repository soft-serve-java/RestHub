package com.kh013j.model.repository;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findFirstByTablenumberAndClosedFalse(int tablenumber);
    List<Order> findAllByClosedFalse();
    @Query(value = "SELECT COUNT(\"order\".id), EXTRACT(MONTH FROM \"order\".time) AS month  FROM rh.\"order\"\n" +
            "GROUP BY month ORDER BY month", nativeQuery = true)
    List<Object[]> orederByMounth();
}