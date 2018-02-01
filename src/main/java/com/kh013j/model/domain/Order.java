package com.kh013j.model.domain;

import java.sql.Time;
import java.util.List;
import lombok.Data;

@Data
public class Order {
  long id;
  Time time;
  User user;
  boolean isClosed;
  List<OrderedDish> orderedFood;

}
