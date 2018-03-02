package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Status;
import com.kh013j.model.exception.DishNotFound;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderedDishService {
    OrderedDish create(OrderedDish dish);

    List<OrderedDish> createAll(List<OrderedDish> dishes, Order order);

    void setCooking(long id);

    OrderedDish delete(long id) throws DishNotFound;

    List<OrderedDish> findAll();

    OrderedDish update(OrderedDish dish) throws DishNotFound;

    OrderedDish findById(long id);

    List<OrderedDish> findAllByStatusIn(List<Status> statuses);

    void setDone(long id);

    List<OrderedDish> findAllForCooker();

    @Transactional
    void setDelivered(long id);

    List<OrderedDish> createOrderedDishesFromMap(Map<Dish, Integer> orderMap, Order order);

    OrderedDish createOrderedDishFromDish(Dish dish, Order order, int quantity);
}
