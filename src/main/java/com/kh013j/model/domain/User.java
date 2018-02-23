package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "rh")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Email
    @Size(min=(5), max=50)
    private String email;

    @Size(min=(5), max=100)
    private String psword;

    @Size(min=(2), max=50)
    private String name;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
