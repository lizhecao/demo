package com.test.demo.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Date 2016年11月11日 下午2:59:29
 * @author ryan
 * @version 1.0
 * @since JDK 1.8
 */
public class Lambda {
  private int num;
  private String name;

  public Lambda(int num, String name) {
    this.num = num;
    this.name = name;
  }

  public void print() {
    System.out.format("num = %s, name = %s\n", num, name);
  }

  public static void main(String[] args) {

    // runnable
    new Thread(new Runnable() {
      public void run() {
        System.out.println("hello world one");
      }
    }).start();

    new Thread(() -> System.out.println("hello world two")).start();

    // Collections.sort
    Lambda[] a = new Lambda[3];
    a[0] = new Lambda(1, "b");
    a[1] = new Lambda(2, "a");
    a[2] = new Lambda(3, "c");

    Arrays.sort(a, new Comparator<Lambda>() {
      @Override
      public int compare(Lambda o1, Lambda o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });

    for (Lambda b : a) {
      b.print();
    }

    Arrays.sort(a, (x, y) -> x.getNum() - y.getNum());

    List<Lambda> b = Arrays.asList(a);
    b.forEach(Lambda::print);

    List<String> languages = Arrays.asList("java", "C++", "scala", "python", "C", "R", "PHP");
    Predicate<String> condition = (str) -> str.startsWith("C");

    languages.forEach(x -> {
      if (condition.test(x)) {
        System.out.println(x);
      }
    });
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

