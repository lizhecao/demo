package com.test.demo.mybatis;

import com.test.demo.jdbc.Person;

/**
 * Created by ryan on 2017/6/6.
 */
public interface PersonMapper {
  public Person queryById(String id);
}
