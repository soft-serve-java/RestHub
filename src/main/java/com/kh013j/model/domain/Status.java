package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "status", schema = "rh")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @Id
    @SequenceGenerator(name = "status-sequence_generator", sequenceName = "status_sequence")
    @GeneratedValue(generator = "status-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Transient
    public static final String PREPARING = "preparing";

    @Transient
    public static final String COOKING = "cooking";

    @Transient
    public static final String DELIVERY = "delivery";

    @Transient
    public static final String DONE = "done";
}