package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Status;
import com.kh013j.model.exception.DishNotFound;
import java.util.List;

public interface OrderedDishService {
  OrderedDish create(OrderedDish dish);

  List<OrderedDish> createAll(List<OrderedDish> dishes, Order order);
  void setCooking(long id);
  OrderedDish delete(long id) throws DishNotFound;
  List findAll();
  OrderedDish update(OrderedDish dish) throws DishNotFound;
  OrderedDish findById(long id);
  List<OrderedDish> findAllByStatusIn(List<Status> statuses);
  void setDone(long id);
  public List<OrderedDish> findAllForCooker();
}
