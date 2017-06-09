package com.test.demo.mybatis;

import com.test.demo.jdbc.Person;
import com.test.demo.mybatis.dao.AuthorDao;
import com.test.demo.mybatis.dao.BlogDao;
import com.test.demo.mybatis.entity.Author;
import com.test.demo.mybatis.entity.Blog;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by ryan on 2017/6/6.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//    SqlSession sqlSession1 = sqlSessionFactory.openSession();
//    try {
//      Main.queryBlog(sqlSession);
//      Main.queryBlog(sqlSession1);
//    } finally {
//      sqlSession.close();
//      sqlSession1.close();
//    }
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      Main.queryBlog(sqlSession);
      sqlSession.commit();
    }
  }

  public static void testPerson(SqlSession sqlSession) {
//      Person person = (Person) sqlSession.selectOne("com.test.demo.mybatis.PersonMapper.queryById", 1);
    // 这种方式更简洁只管一些，而且不用担心字符串写错了
    PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
    Person person = personMapper.queryById("4");

    System.out.println(person);
  }

  public static void testAuthor(SqlSession sqlSession) {
//    AuthorDao authorDao = sqlSession.getMapper(AuthorDao.class);
//
//    Author author = new Author(1, "ryan", "hello123");
//
//    authorDao.addAuthor(author);
  }

  public static void addBlog(SqlSession sqlSession) {
//    BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
//
//    Author author = new Author(4, "ethan", "123");
//    Blog blog = new Blog(2, "ethandeblog", author);
//
//    blogDao.addBlog(blog);
  }

  public static void queryBlog(SqlSession sqlSession) {
    BlogDao blogDao = sqlSession.getMapper(BlogDao.class);

    List<Blog> blog = blogDao.queryByTitle("*deblog");
    blog.forEach(System.out::println);
  }
}
