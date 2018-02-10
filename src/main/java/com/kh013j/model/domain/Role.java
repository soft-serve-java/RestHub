package com.kh013j.model.domain;

//import com.kh013j.model.annotation.RestHubEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role", schema = "rh")
//@RestHubEntity(table = @Table(name="role", schema = "rh"))
public class Role {
  @Id
  private long id;
  @Column(length = 50)
  private String name;
}
