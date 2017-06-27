package com.test.demo.common;

/**
 * an identifier followed by a colon
 * Created by ryan on 2017/6/22.
 */
public class GotoTest {

  public static void main(String[] args) {
    outerLoop:
    while (true) {
      System.out.println("outer");
      innerLoop:
      while (true) {
        System.out.println("inner");
//        continue;
//        break;
//        break outerLoop;
        continue outerLoop;
      }
    }
  }
}
