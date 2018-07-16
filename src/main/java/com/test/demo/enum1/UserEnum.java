package com.test.demo.enum1;

/**
 * @author lizhecao 2018/5/29
 * @version 1.0
 */
public enum  UserEnum {
  A(1, 2), B(2, 3);
  private int a;
  private int b;
  private int result;

  UserEnum(int a, int b) {
    this.a = a;
    this.b = b;
    this.result = a * b;
  }

  public int getResult() {
    return result;
  }

  public static void main(String[] args) {
    System.out.println(UserEnum.A.getResult());
    System.out.println(UserEnum.B.getResult());

    for(UserEnum userEnum: UserEnum.values()) {
      System.out.println(userEnum.toString());
    }
  }
}
