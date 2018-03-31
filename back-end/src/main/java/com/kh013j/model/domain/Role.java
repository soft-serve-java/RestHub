package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Size(min = 2, max = 50)
    private String name;

    public Role(@Size(min = 2, max = 50) String name) {
        this.name = name;
    }
}
