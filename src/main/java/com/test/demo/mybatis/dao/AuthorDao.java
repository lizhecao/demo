package com.test.demo.mybatis.dao;

import com.test.demo.mybatis.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ryan on 2017/6/7.
 */
public interface AuthorDao {
  void addAuthor(Author author);
  @Select("select * from author where id = #{id}")
  Author queryById(int id);
}
