package com.test.demo.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by ryan on 2017/6/2.
 */
@Service
public class HelloServiceImpl implements HelloService {

  @Override
  public void hello() {
    System.out.println("hello");
  }

  @Override
  public String hello2(String test) {
    System.out.println("hello2");
    return test + ", hello";
  }

  @Override
  public void hello3(String a1, String a2) {
    System.out.println(a1 + " | " + a2);
  }
}
