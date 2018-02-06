package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order", schema = "rh")
public class Order {
  @Id
  private long id;
  private Timestamp time;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  private int tableNumber;
  @Column(name ="close")
  private boolean isClosed;
  @OneToMany
  @JoinColumn(name="id")
  private List<OrderedDish> orderedFood;

}
