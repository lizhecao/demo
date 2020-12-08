package com.test.demo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */
public class Test {

//  public static void main(String[] args) {
////    Integer i = 1;
////    testInteger(i);
////    System.out.printf("" + i);
//    List<String> list = null;
//    for (String s: list) {
//      System.out.println(s);
//    }
//  }

  public static void testInteger(Integer i) {
    i += 1;
    System.out.printf("" + i);
  }

  public static void main(String[] args) {
    int []a = new int[]{1,2,3,4,5};
    int len = a.length;
    int []b = Arrays.copyOfRange(a, 0, len - 1);
    printArray(b);
    int []c = new int[len - 1];
    for (int i = 0;i < len -1; i++) {
      c[i] =a[i];
    }
    printArray(c);
  }

  private static void printArray(int[] b) {
    for (int i = 0;i < b.length;i++) {
      System.out.println(b[i]);
    }
  }


}
