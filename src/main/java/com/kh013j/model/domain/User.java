package com.kh013j.model.domain;

import lombok.Data;

@Data
public class User {
  long id;
  String login;
  String password;
  String email;
  Role role;
}
