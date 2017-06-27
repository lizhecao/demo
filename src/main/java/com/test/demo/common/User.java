package com.test.demo.common;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ryan on 2017/6/22.
 */

@Getter
@Setter
class User extends Person implements Serializable {
  public static String username;
  private transient  String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}

@Setter
@Getter
class Person implements Serializable{
  private String sex;
}
