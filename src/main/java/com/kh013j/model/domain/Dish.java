package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "dish", schema = "rh")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  @Column(length = 50)
  private String name;
  @Column(length = 1000)
  private String description;
  private int weight;
  private int calories;
  @Column(length = 50)
  private String preparingtime;
  private int price;
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;
  @Column(length = 100)
  private String picture;
  private boolean avalibility;
}
