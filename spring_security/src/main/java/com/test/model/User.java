package com.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author lizhecao 2018/5/17
 * @version 1.0
 */
@Entity
@Data
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @Column(unique = true)
  private String name;
  private String password;

  protected User(){}

  public User(User user) {
    this.name = user.getName();
    this.password = user.getPassword();
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }
}
