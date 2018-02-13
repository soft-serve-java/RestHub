package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Order;
import com.kh013j.model.exception.DishNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

  void create(Order order);
  Order delete(long id) ;
  List findAll();
  Order update(Order order);
  Order findById(long id);
  Order findByTable(int table);
}
