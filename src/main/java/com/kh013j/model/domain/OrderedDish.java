package com.kh013j.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdish", schema = "rh")
public class OrderedDish {
    @Id
    long id;
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    private int quantity;
}
