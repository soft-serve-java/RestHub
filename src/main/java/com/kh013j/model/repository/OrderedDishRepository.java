package com.kh013j.model.repository;

import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedDishRepository extends JpaRepository<OrderedDish, Long> {
    public List<OrderedDish> findAllByStatusIn(List<Status> statuses);
    @Query(value = "SELECT rh.orderdish.order_id FROM rh.orderdish WHERE rh.orderdish.id = ?1",
            nativeQuery = true)
    public long getOrderId(long id);
}
