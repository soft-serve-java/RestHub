package com.kh013j.model.domain;

import java.sql.Time;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private long id;
  private Time time;
  private User user;
  private boolean isClosed;
  private List<OrderedDish> orderedFood;

}
