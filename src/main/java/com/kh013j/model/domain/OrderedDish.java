package com.kh013j.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OrderedDish extends Dish {
  private Order order;
  private Status status;
  private int quantity;
}
