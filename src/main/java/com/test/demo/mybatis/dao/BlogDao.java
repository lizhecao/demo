package com.test.demo.mybatis.dao;

import com.test.demo.mybatis.entity.Blog;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ryan on 2017/6/7.
 */
public interface BlogDao {
  Blog queryById(int id);
  List<Blog> queryByTitle(@Param("title") String title);
  void addBlog(Blog blog);
}
