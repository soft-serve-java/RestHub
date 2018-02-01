package com.kh013j.model.domain;

import lombok.Data;

@Data
public class User {
  private long id;
  private String login;
  private String password;
  private String email;
  private Role role;
}
