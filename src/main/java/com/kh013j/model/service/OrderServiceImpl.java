package com.kh013j.model.service;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Order;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderRepository;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    @Resource
    OrderRepository orderRepository;

    @Autowired
    private OrderedDishService orderedDishService;

    @Override
    public void create(Order order) {
        Order newOrder = orderRepository.save(order);
    }

    @Override
    public Order delete(long id) throws DishNotFound {
        return null;
    }

    @Override
    public List findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order update(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order findByTable(int table) {
        return orderRepository.findFirstByTablenumberAndCloseFalse(table);
    }

    @Override
    public Order createOrderFromMap(Map<Dish, Integer> orderMap, int tablenumber) {
        Order order = new Order();
        order.setTime(new Timestamp(new Date().getTime()));
        order.setTablenumber(tablenumber);
        order.setOrderedFood(orderedDishService.createOrderedDishesFromMap(orderMap, order));
        return order;
    }

    @Override
    public void onSubmitOrder(int tablenumber, Map<Dish, Integer> orderMap) {
        Order order = findByTable(tablenumber);
        if (order != null) {
            order.getOrderedFood().addAll(orderedDishService.createOrderedDishesFromMap(orderMap, order));
        } else {
            order = createOrderFromMap(orderMap, tablenumber);
        }
        orderRepository.saveAndFlush(order);
    }
}

