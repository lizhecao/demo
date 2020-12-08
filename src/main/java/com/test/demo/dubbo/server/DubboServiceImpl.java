package com.test.demo.dubbo.server;

import com.test.demo.dubbo.DubboService;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by lizhecao on 2017-8-2.
 */
@Component(value = "demoService")
public class DubboServiceImpl implements DubboService {

  @Override
  public String sayHello(String name) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "hello " + name;
  }

  public static void main(String[] args) throws IOException {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dubbo-provider.xml");
    System.in.read();
  }
}
