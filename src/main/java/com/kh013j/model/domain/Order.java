package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Timestamp time;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int tablenumber;
    @Column(name = "closed")
    private boolean closed;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderedDish> orderedFood = new ArrayList<>();

}
