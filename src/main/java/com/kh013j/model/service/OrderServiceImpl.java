package com.kh013j.model.service;

import com.kh013j.model.domain.Order;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderRepository;
import com.kh013j.model.service.interfaces.OrderService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

public class OrderServiceImpl implements OrderService {
  @Resource
  OrderRepository orderRepository;

  @Override
  public Order create(Order order) {
    return orderRepository.save(order);
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
  public Order update(Order order) throws DishNotFound {
    return null;
  }

  @Override
  public Order findById(long id) {
    return orderRepository.findOne(id);
  }
}
