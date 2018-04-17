package com.kh013j.model.domain;

import com.kh013j.model.domain.converter.PriceConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "dish", schema = "rh")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "images")
public class Dish {
    @Id
    @SequenceGenerator(name = "dish-sequence_generator", sequenceName = "dish_sequence")
    @GeneratedValue(generator = "dish-sequence_generator", strategy = GenerationType.IDENTITY)
    long id;

    @Size(min = 3, max = 50)
    private String name;

    private String description;

    private int weight;

    @Max(5000)
    private int calories;

    @Min(0)
    private int preparingtime;

    @Min(0) @Max(100000)
    @Convert(converter = PriceConverter.class)
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="dish_id")
    private List<Image> images = new LinkedList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="tagdish",
            schema = "rh",
            joinColumns=@JoinColumn(name="dish_id", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="tag_id", referencedColumnName="ID")
    )
    private List<Tag> tags;

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
        this.images = dish.getImages();
        this.availability = dish.isAvailability();
        this.tags = dish.getTags();
    }
}
