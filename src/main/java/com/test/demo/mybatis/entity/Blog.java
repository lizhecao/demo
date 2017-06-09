package com.test.demo.mybatis.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by ryan on 2017/6/7.
 */
@ToString
public class Blog implements Serializable {
  private int id;
  private String title;
  private Author author;
//  private List<Post> posts;

  public Blog(){}

  public Blog(int id, String title, Author author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }
}
