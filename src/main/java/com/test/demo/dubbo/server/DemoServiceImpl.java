package com.test.demo.dubbo.server;

import com.test.demo.dubbo.DemoService;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by lizhecao on 2017-8-2.
 */
@Component(value = "demoService")
public class DemoServiceImpl implements DemoService {

  @Override
  public String sayHello(String name) {
    return "hello " + name;
  }

  public static void main(String[] args) throws IOException {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dubbo-provider.xml");
    System.in.read();
  }
}
