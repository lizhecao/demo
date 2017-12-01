package com.test.demo.dubbo.client;

import com.test.demo.dubbo.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lizhecao on 2017-8-2.
 */
public class Client {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dubbo-consumer.xml");
    DemoService demoService = (DemoService)applicationContext.getBean("demoService");
    System.out.println(demoService.sayHello("ryan"));
  }
}
