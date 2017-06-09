package com.test.demo.mybatis.service.impl;

import com.test.demo.mybatis.dao.BlogDao;
import com.test.demo.mybatis.entity.Blog;
import com.test.demo.mybatis.service.BlogService;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ryan on 2017/6/8.
 */
@Component
@Transactional
public class BlogServiceImpl implements BlogService {
  @Resource
  private BlogDao blogDao;
  @Override
  public Blog getBlog(int id) {
    return blogDao.queryById(id);
  }

  @Override
  public void addBlog(Blog blog) {
    blogDao.addBlog(blog);
  }
}
