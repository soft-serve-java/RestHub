package com.kh013j.model.service;

import com.kh013j.model.domain.Order;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderRepository;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public class OrderServiceImpl implements OrderService {
  @Resource
  OrderRepository orderRepository;
  @Autowired
  private OrderedDishService orderedDishService;

  @Override
  public void create(Order order) {
    Order newOrder = orderRepository.save(order);
    //orderedDishService.createAll(order.getOrderedFood(), newOrder);

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
}
