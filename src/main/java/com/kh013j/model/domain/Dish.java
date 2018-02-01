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
  private long id;
  private String name;
  private String description;
  private String weight;
  private String calories;
  private Time time;
  private int price;
  @ManyToOne
  @JoinColumn(name = "category_id")
  Category category;
  String picture;
  boolean availability;
}
