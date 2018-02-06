package com.kh013j.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "rh")
public class User {
  @Id
  private long id;
  @Size(min = 15, max = 50)
  private String login;
  @Size(min = 8, max = 50)
  private String password;
  @Size(min = 15, max = 50)
  private String email;
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;
}
