package com.test.demo.mybatis.dao;

import com.test.demo.mybatis.entity.Post;

/**
 * Created by ryan on 2017/6/9.
 */
public interface PostDao {
  Post queryById(String id);
}
