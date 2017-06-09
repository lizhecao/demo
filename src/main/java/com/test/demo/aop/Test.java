package com.test.demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ryan on 2017/6/2.
 */
public class Test {

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-base.xml");
    HelloService helloService = (HelloService) ctx.getBean("helloServiceImpl");
   // helloService.hello2("haha");
    helloService.hello3("a", "b");
  }
}
