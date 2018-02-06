package com.kh013j.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "dish" , schema = "rh")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  @Size(min=3, max=50)
  private String name;
  @Size(max = 1000)
  private String description;
  @Min(100)
  @Max(3000)
  private int weight;
  private int calories;
  @Min(5)
  @Max(120)
  private String preparingtime;
  @Min(1)
  @Max(2000)
  private int price;
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;
  @Min(20)
  @Max(100)
  private String picture;
  private boolean avalibility;
}
