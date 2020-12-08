package com.test.demo.mybatis.entity;

import lombok.ToString;

/**
 * Created by ryan on 2017/6/1.
 */
@ToString
public class Person {
  private int id;
  private String name;

  public Person() {}

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
