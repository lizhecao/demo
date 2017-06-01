package com.test.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ryan on 2017/3/15.
 */
public class GenericType {

  public static void main(String[] args) {
    List<? extends Number> nums = new ArrayList<Integer>();
    // nums.add(1);
    List<Integer> ints = Arrays.asList(1, 2);
    List<Double> doubles = Arrays.asList(1.1, 2.2);


//    nums.add(1.1);
//    nums.addAll(ints);
//    nums.addAll(doubles);
    nums = ints;

    GenericType genericType = new GenericType();
    genericType.print(ints);
    genericType.print(doubles);

    //genericType.add
  }

  // print all Number 或 Number 子类的list, 如果没有通配符的话, 估计得一个一个子类都去实现以下。。。
  public void print(List<? extends Number> list) {
    list.forEach(x -> System.out.println(x));
  }
}
