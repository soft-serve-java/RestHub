package com.kh013j.model.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdish" , schema = "rh")
public class OrderedDish {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  @ManyToOne
  @JoinColumn(name = "dish_id")
  private Dish dish;
  @ManyToOne
  @JoinColumn(name = "status_id")
  private Status status;
  private int quantity;
}
