package com.test.demo.dubbo.client;

import com.test.demo.dubbo.DubboService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lizhecao on 2017-8-2.
 */
public class DubboClient {

  public static void main(String[] args) throws InterruptedException {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dubbo-consumer.xml");
    DubboService dubboService = (DubboService)applicationContext.getBean("dubboService");
    System.out.println(dubboService.sayHello("ryan"));
    Thread.sleep(1000000);
  }
}
