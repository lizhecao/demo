package com.test.demo.mybatis.service.impl;

import com.test.demo.mybatis.dao.AuthorDao;
import com.test.demo.mybatis.entity.Author;
import com.test.demo.mybatis.service.AuthorService;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ryan on 2017/6/8.
 */
@Component
@Transactional
public class AuthorServiceImpl implements AuthorService {
  @Resource
  private AuthorDao authorDao;

  @Override
  public Author getAuthor(int id) {
    return authorDao.queryById(id);
  }

  @Override
  public void addAuthor(Author author) {
    authorDao.addAuthor(author);
    throw new RuntimeException();
  }
}
