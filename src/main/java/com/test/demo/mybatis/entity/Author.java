package com.test.demo.mybatis.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by ryan on 2017/6/7.
 */
@ToString
public class Author implements Serializable {
  private int id;
  private String username;
  private String password;

  public Author(){}

  public Author(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }
}
