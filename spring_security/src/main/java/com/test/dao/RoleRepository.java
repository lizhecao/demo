package com.test.dao;

import com.test.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author lizhecao 2018/5/17
 * @version 1.0
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
  List<Role> findByUserId(int userId);
}
