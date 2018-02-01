package com.kh013j.model.domain;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "dish")
@Data
@ToString
public class Dish {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  String name;
  String description;
  String weight;
  String calories;
  Time time;
  int price;
  @ManyToOne
  @JoinColumn(name = "category_id")
  Category category;
  String picture;
  boolean availability;
}
