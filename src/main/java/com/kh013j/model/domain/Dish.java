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
    Long id;
    private String name;
    private String description;
    private int weight;
    private int calories;
    private int preparingtime;
    private int price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String picture;
    private boolean availability;

    public Dish(Dish dish) {
        this.id = dish.getId();
        this.name = dish.getName();
        this.description = dish.getDescription();
        this.weight = dish.getWeight();
        this.calories = dish.getCalories();
        this.preparingtime = dish.getPreparingtime();
        this.price = dish.getPrice();
        this.category = dish.getCategory();
        this.picture = dish.getPicture();
        this.availability = dish.isAvailability();
    }
}
