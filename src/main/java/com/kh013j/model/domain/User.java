package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "rh")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Min(5) @Max(50)
    private String login;

    @Min(6) @Max(50)
    private String password;

    @Min(6) @Max(50)
    private String name;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
