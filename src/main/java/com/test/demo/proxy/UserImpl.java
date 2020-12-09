package com.test.demo.proxy;

/**
 * 目标对象的具体类
 *
 * @author lizhecao 2018/4/19
 * @version 1.0
 */
public class UserImpl {
  public void sayHello(String name, Integer code) {
    System.out.println("hello");
  }
}
