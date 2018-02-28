package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "order", schema = "rh")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Past
    private Timestamp time;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int tablenumber;
    @Column(name = "closed")
    private boolean closed;
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<OrderedDish> orderedFood = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "waiter")
    User waiter;

    public boolean hasFoodForDeliver(){
        long countOfFoodOnDelivery = orderedFood.stream()
                .filter(orderedDish -> orderedDish.getStatus().getName().equals(Status.DELIVERY)).count();
        return countOfFoodOnDelivery>0;
    }
}
