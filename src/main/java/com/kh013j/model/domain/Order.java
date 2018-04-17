package com.kh013j.model.domain;

import lombok.*;

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

    @Column(name = "wish")
    private String wish;

    public Order(Order order, String wish){
        this.id = order.getId();
        this.closed = order.isClosed();
        this.orderedFood = order.getOrderedFood();
        this.user = order.getUser();
        this.time = order.getTime();
        this.tablenumber = order.getTablenumber();
        this.waiter = order.getWaiter();

        this.wish = wish;
    }

    public boolean hasFoodForDeliver(){
        long countOfFoodOnDelivery = orderedFood.stream()
                .filter(orderedDish -> orderedDish.getStatus().getName().equals(Status.DELIVERY)).count();
        return countOfFoodOnDelivery>0;
    }


}