package com.kh013j.model.repository;

import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedDishRepository extends JpaRepository<OrderedDish, Long> {
     List<OrderedDish> findAllByStatusIn(List<Status> statuses);
    @Query(value = "SELECT rh.orderdish.order_id FROM rh.orderdish WHERE rh.orderdish.id = ?1",
            nativeQuery = true)
     long getOrderId(long id);
    @Query(value = "SELECT SUM(derivedTable.count*derivedTable.quantity) AS sum, derivedTable.name FROM (\n" +
            "SELECT COUNT (rh.orderdish.id), orderdish.quantity, dish.name\n" +
            "FROM rh.orderdish INNER JOIN rh.dish ON orderdish.dish_id = rh.dish.id\n" +
            "GROUP BY dish.name, orderdish.quantity)\n" +
            "AS derivedTable GROUP BY name;",
            nativeQuery = true)
    List<Object[]> getTheMostPopular();

    @Query(value = "SELECT COUNT (rh.orderdish.id), orderdish.quantity, rh.dish.name FROM rh.orderdish INNER JOIN rh.dish ON orderdish.dish_id = rh.dish.id WHERE\n" +
            "  rh.orderdish.order_id IN\n" +
            "  (SELECT rh.\"order\".id FROM rh.\"order\" WHERE EXTRACT(ISOYEAR FROM \"order\".time )\n" +
            "  = EXTRACT(ISOYEAR FROM now()) AND EXTRACT(WEEK FROM \"order\".time) = EXTRACT(WEEK FROM NOW())) GROUP BY name, quantity  ORDER BY quantity DESC", nativeQuery = true)
    List<Object[]> theDishOfTheWeek();
}
