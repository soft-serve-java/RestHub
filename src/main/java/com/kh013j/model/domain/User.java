package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "rh")
public class User {
  @Id
  private long id;
  @Column(length = 50)
  private String email;
  @Column(length = 50)
  private String login;
  @Column(length = 50)
  private String password;
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;
}
