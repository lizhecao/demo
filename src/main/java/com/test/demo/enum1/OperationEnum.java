package com.test.demo.enum1;

/**
 * @author lizhecao 2018/5/29
 * @version 1.0
 */
public enum  OperationEnum {
  PLUS {
    @Override
    double apply(double x, double y) {
      return x + y;
    }
  },
  MINUS {
    @Override
    double apply(double x, double y) {
      return x - y;
    }
  },
  TIMES {
    @Override
    double apply(double x, double y) {
      return x * y;
    }
  },
  DIVIDE {
    @Override
    double apply(double x, double y) {
      return x / y;
    }
  };

  OperationEnum(){}
  abstract double apply(double x, double y);

  public static void main(String[] args) {
    System.out.println(PLUS.apply(3, 4));
  }
}
