package com.kh013j.model.domain;

//import com.kh013j.model.annotation.RestHubEntity;

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
@Table(name = "role", schema = "rh")
//@RestHubEntity(table = @Table(name="role", schema = "rh"))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(2) @Max(50)
    private String name;
}
