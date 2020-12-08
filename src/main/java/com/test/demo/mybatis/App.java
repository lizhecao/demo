package com.test.demo.mybatis;

import com.test.demo.mybatis.entity.Author;
import com.test.demo.mybatis.entity.Blog;
import com.test.demo.mybatis.service.AuthorService;
import com.test.demo.mybatis.service.BlogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ryan on 2017/6/8.
 */
public class App {

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    AuthorService authorService = (AuthorService)ctx.getBean("authorServiceImpl");
//    System.out.println(authorService.getAuthor(1));
//    BlogService blogService = (BlogService)ctx.getBean("blogServiceImpl");
//    blogService.getBlog(1);
    /**
     * 事务传播测试
     */
//    authorService.addAuthor(new Author(8, "jobs", "1234"));
    /**
     * 事务隔离测试
     */
//    authorService.addAuthor4IsolationTest(new Author(8, "jobs", "1234"));
    Author author = authorService.getAuthor(8);
    System.out.println(author);
  }
}
