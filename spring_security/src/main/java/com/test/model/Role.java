package com.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lizhecao 2018/5/17
 * @version 1.0
 */
@Entity
@Data
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  /**
   * 角色名称：USER,ADMIN
   */
  private String name;
  private int userId;

  protected Role(){}

  public Role(String name, int userId) {
    this.name = name;
    this.userId = userId;
  }
}
