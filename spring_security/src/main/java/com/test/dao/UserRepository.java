package com.test.dao;

import com.test.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author lizhecao 2018/5/17
 * @version 1.0
 */
public interface UserRepository extends CrudRepository<User, Integer> {
  User findByName(String name);
}
