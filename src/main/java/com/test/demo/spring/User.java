package com.test.demo.spring;

/**
 * Created by lizhecao on 2017-8-31.
 */
public class User {
  private String name;
  private int sex; // 男 0 女 1
  private String phone;

  public User(String name, int sex, String phone) {
    this.name = name;
    this.sex = sex;
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "name: " + name + " sex: " + sex + " phone: " + phone;
  }
}
