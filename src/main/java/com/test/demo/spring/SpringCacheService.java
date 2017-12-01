package com.test.demo.spring;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lizhecao on 2017-8-31.
 */
public class SpringCacheService {
  @Cacheable(value = "default")
  public User getUser(String name) {
    System.out.println("start find user in db");
    return new User(name, 0, "250");
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cache.xml");
    SpringCacheService cacheService = (SpringCacheService) ctx.getBean("springCacheService");
    System.out.println("first getuser: " + cacheService.getUser("ryan"));
    System.out.println("second getuser: " + cacheService.getUser("ryan"));
  }
}
