package com.kh013j.model.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

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
    @Size(min = 3, max = 50)
    private String name;
    private String description;
    private int weight;
    @Max(5000)
    private int calories;
    @Min(0)
    private int preparingtime;
    @Max(100000)
    // change price type!
    private BigDecimal price;
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
