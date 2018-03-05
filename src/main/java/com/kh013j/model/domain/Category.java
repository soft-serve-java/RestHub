package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category", schema = "rh")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @SequenceGenerator(name = "category-sequence_generator", sequenceName = "category_sequence")
    @GeneratedValue(generator = "category-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min=3, max=50)
    private String name;
}

