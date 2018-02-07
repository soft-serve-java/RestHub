package com.kh013j.model.domain;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order" , schema = "rh")
public class Order {
  @Id
  private long id;
  private Timestamp time;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  @Min(1)
  @Max(50)
  private int tableNumber;
  @Column(name ="close")
  private boolean isClosed;
  @OneToMany
  @JoinColumn(name="id")
  private List<OrderedDish> orderedFood;

}
