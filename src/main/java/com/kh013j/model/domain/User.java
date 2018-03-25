package com.kh013j.model.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "user", schema = "rh")
@JsonAutoDetect
public class User  {
    @Id
    @SequenceGenerator(name = "user-sequence_generator", sequenceName = "user_sequence")
    @GeneratedValue(generator = "user-sequence_generator", strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Email
    @Size(min = 5, max = 50)
    @JsonProperty("username")
    private String email;

    @Size(min = 5, max = 100)
    private String password;

    @Size(min = 2, max = 50)
    private String name;

    private String confirmationtoken;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    @JoinTable(
            schema = "rh",
            name = "userrole",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )

    private Set<Role> roles;
    private String avatar;

    public User(User user) {
        this.email = user.email;
        this.password = user.password;
        this.name = user.name;
        this.confirmationtoken = user.confirmationtoken;
        this.enabled = user.enabled;
        this.roles = user.roles;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roleList = new ArrayList<>();
        for (Role role: roles) {
            roleList.add(new SimpleGrantedAuthority(role.getName()));
        }
        return roleList;
    }

}