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
  private String email;
  private String login;
  private String password;
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;
}
