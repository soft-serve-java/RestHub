package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "rh")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 1;

    @Email
    @Size(min=(5), max=50)
    private String email;

    @Size(min=(5), max=100)
    private String psword;

    @Size(min=(2), max=50)
    private String name;

    private String confirmationtoken;

    private boolean enabled;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "userrole",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> roles;
}
