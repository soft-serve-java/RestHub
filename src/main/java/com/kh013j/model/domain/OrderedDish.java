package com.kh013j.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class OrderedDish extends Dish {
  Order order;
  Status status;
   int quantity;
}
