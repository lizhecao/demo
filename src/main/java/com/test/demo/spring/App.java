package com.test.demo.spring;

import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/1/4.
 */
public class App {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-base.xml");
    Teacher teacher = (Teacher)ctx.getBean("teacher");
    System.out.println(teacher.toString());

    try {
      App.class.getDeclaredConstructors()[0].newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    String s = "你好";
    byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
    for (int i = 0; i < bytes.length; i++) {
      System.out.println(bytes[i]);
    }
  }
}
