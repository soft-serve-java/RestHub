package com.kh013j.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
  @Id
  private long id;
  private String login;
  private String password;
  private String email;
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;
}
