package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "review", schema = "rh")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @SequenceGenerator(name = "review-sequence_generator", sequenceName = "review_sequence")
    @GeneratedValue(generator = "review-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 1000)
    private String commentText;

    private Timestamp date;

    private Boolean approved;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
