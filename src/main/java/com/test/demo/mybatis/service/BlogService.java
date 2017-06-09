package com.test.demo.mybatis.service;

import com.test.demo.mybatis.entity.Blog;

/**
 * Created by ryan on 2017/6/8.
 */
public interface BlogService {
  Blog getBlog(int id);
  void addBlog(Blog blog);
}
