package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdish", schema = "rh")
public class OrderedDish {
    @Id
    @SequenceGenerator(name = "orderdish-sequence_generator", sequenceName = "orderdish_sequence")
    @GeneratedValue(generator = "orderdish-sequence_generator", strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    private int quantity;
}
