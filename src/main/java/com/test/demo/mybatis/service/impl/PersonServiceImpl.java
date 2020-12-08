package com.test.demo.mybatis.service.impl;

import com.test.demo.mybatis.dao.PersonDao;
import com.test.demo.mybatis.entity.Person;
import com.test.demo.mybatis.service.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author lizhecao 2019/4/11
 * @version 1.0
 */
@Component
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PersonServiceImpl implements PersonService {
  @Resource
  private PersonDao personDao;

  @Override
  public void addPerson(Person person) {
    personDao.addPerson(person);
    throw new RuntimeException();
  }
}
