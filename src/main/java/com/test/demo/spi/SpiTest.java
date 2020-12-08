package com.test.demo.spi;

import java.util.ServiceLoader;

/**
 * @author lizhecao 2019/4/9
 * @version 1.0
 */
public class SpiTest {
  public static void main(String[] args) {
    ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
    System.out.println("Java SPI");
    serviceLoader.forEach(Robot::sayHello);
  }
}
