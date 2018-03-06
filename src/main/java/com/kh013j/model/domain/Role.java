package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role", schema = "rh")
public class Role implements Serializable {
    @Id
    @SequenceGenerator(name = "role-sequence_generator", sequenceName = "role_sequence")
    @GeneratedValue(generator = "role-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id;

    @Min(2) @Max(50)
    private String name;
}