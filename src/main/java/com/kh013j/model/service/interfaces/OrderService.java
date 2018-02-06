package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Order;
import com.kh013j.model.exception.DishNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

  Order create(Order order);
  Order delete(long id) throws DishNotFound;
  List findAll();
  Order update(Order order) throws DishNotFound;
  Order findById(long id);

}
