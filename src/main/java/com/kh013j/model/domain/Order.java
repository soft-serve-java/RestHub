package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "order", schema = "rh")
public class Order {
    @Id
    @SequenceGenerator(name = "order-sequence_generator", sequenceName = "order_sequence")
    @GeneratedValue(generator = "order-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Past
    private Timestamp time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private int tablenumber;
    @Column(name = "closed")
    private boolean closed;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<OrderedDish> orderedFood;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "waiter")
    User waiter;

    @Transient
    private String wish;

    public boolean hasFoodForDeliver(){
        long countOfFoodOnDelivery = orderedFood.stream()
                .filter(orderedDish -> orderedDish.getStatus().getName().equals(Status.DELIVERY)).count();
        return countOfFoodOnDelivery>0;
    }
}