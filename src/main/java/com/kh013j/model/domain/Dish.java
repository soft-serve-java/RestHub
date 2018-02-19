package com.kh013j.model.domain;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dish", schema = "rh")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@RestHubEntity(table = @Table(name="dish", schema = "rh"))
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Size(min = 3, max = 50)
    private String name;
    private String description;
    @Min(2) @Max(10000)
    private int weight;
    @Max(5000)
    private int calories;
    @Min(0)
    private String preparingtime;
    @Max(100000)
    private int price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String picture;
    private boolean avalibility;
}
