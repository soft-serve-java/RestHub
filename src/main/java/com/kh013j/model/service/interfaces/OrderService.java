package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Order;
import com.kh013j.model.exception.DishNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {

    Order create(Order order);

    Order delete(long id) throws DishNotFound;

    List findAll();

    Order update(Order order);

    Order findById(long id);

    Order findByTable(int table);

    Order createOrderFromMap(Map<Dish, Integer> orderMap, int tableNumber);

    void onSubmitOrder(int tablenumber, Map<Dish, Integer> orderMap);
}
