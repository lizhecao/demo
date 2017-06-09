package com.test.demo.mybatis.service;

import com.test.demo.mybatis.entity.Author;

/**
 * Created by ryan on 2017/6/8.
 */
public interface AuthorService {
  Author getAuthor(int id);
  void addAuthor(Author author);
}
