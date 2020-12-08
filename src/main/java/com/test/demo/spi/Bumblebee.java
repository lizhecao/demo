package com.test.demo.spi;

/**
 * @author lizhecao 2019/4/9
 * @version 1.0
 */
public class Bumblebee implements Robot {
  @Override
  public void sayHello() {
    System.out.println("I'm Bumblebee");
  }
}
