package com.kh013j.model.service;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderedDishRepository;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public class OrderedDishServiceImpl implements OrderedDishService {
    @Resource
    OrderedDishRepository orderedDishRepository;
    @Override
    @Transactional
    public OrderedDish create(OrderedDish dish) {
        return orderedDishRepository.save(dish);
    }
    @Override
    public List<OrderedDish> createAll(List< OrderedDish> dishes, Order order) {
        dishes.stream().
                forEach(orderedDish -> orderedDish.setOrder(order));
        return orderedDishRepository.save(dishes);
    }

    @Override
    public OrderedDish delete(long id) throws DishNotFound {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public OrderedDish update(OrderedDish dish) throws DishNotFound {
        return null;
    }

    @Override
    public OrderedDish findById(long id) {
        return null;
    }
}
