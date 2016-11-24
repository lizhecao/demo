package com.test.demo;

/**
 * @Date 2016年11月21日 下午2:19:18
 * @author ryan
 * @version 1.0
 * @since JDK 1.8
 */
public class StaticCodeBlock {
  static {
    System.out.println("run the static block");
  }

  {
    System.out.println("first construct block");
  }

  {
    System.out.println("second construct block");
  }

  public StaticCodeBlock() {
    System.out.println("The real Construct function");
  }

  public static void print() {
    System.out.println("I'm the static method");
  }

  public static void main(String[] args) {
    StaticCodeBlock.print();
  }
}

