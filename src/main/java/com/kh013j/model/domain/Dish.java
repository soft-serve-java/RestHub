package com.kh013j.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private String name;
    private String description;
    private int weight;
    private int calories;
    private String preparingtime;
    private int price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String picture;
    private boolean avalibility;
}
