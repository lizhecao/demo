package com.test.demo;

/**
 * Created by Administrator on 2017/1/22.
 */
public class Test {

  public static void main(String[] args) {
    Integer i = 1;
    testInteger(i);
    System.out.printf("" + i);
  }

  public static void testInteger(Integer i) {
    i += 1;
    System.out.printf("" + i);
  }
}
