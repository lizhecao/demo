package com.test.demo.mybatis.dao;

import com.test.demo.jdbc.Person;

/**
 * Created by ryan on 2017/6/6.
 */
public interface PersonDao {
  Person queryById(String id);
}
