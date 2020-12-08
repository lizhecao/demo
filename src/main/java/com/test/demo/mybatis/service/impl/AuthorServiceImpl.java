package com.test.demo.mybatis.service.impl;

import com.test.demo.mybatis.dao.AuthorDao;
import com.test.demo.mybatis.entity.Author;
import com.test.demo.mybatis.entity.Person;
import com.test.demo.mybatis.service.AuthorService;
import javax.annotation.Resource;

import com.test.demo.mybatis.service.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ryan on 2017/6/8.
 */
@Component
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class AuthorServiceImpl implements AuthorService {
  @Resource
  private AuthorDao authorDao;
  @Resource
  private PersonService personService;

  @Override
  public Author getAuthor(int id) {
    return authorDao.queryById(id);
  }

  @Override
  public void addAuthor(Author author) {
    authorDao.addAuthor(author);
    personService.addPerson(new Person(2, "bruce"));
    throw new RuntimeException();
  }

  @Override
  public void addAuthor4IsolationTest(Author author) {
    authorDao.addAuthor(author);
    try {
      Thread.sleep(60000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
