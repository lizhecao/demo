package com.test.demo.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lambda {
  public static void main(String[] args) {
    List<String> languages = Arrays.asList("java", "python", "scala", "C++", "C", "R", "PHP");
    languages.stream().filter(x -> x.startsWith("C")).forEach(System.out::println);
    int charNum =
        languages.stream().map(a -> a.length()).reduce((result, element) -> result + element).get();
    System.out.println(charNum);
    List<Integer> primes = Arrays.asList(2, 3, 5, 3, 11, 13, 11, 19, 23, 29);
    IntSummaryStatistics summary = primes.stream().mapToInt(x -> x).summaryStatistics();
    System.out.println("the max num is " + summary.getMax());
    System.out.println("the sum is " + summary.getSum());
    System.out.println("the avg is " + summary.getAverage());
    int maxNum =
        primes.stream().map(x -> x * x).distinct().collect(Collectors.maxBy((x, y) -> x - y)).get();
    System.out.println(maxNum);
    // collect 使用collector来提供mutable reduction操作,提供了很多有用的collector,如groupingBy,joining,maxBy...
    Map<Integer, List<String>> map =
        languages.stream().collect(Collectors.groupingBy((String x) -> x.length()));
    map.forEach((x, y) -> {
      System.out.print("length is " + x + ": ");
      y.forEach(z -> System.out.print(z + ", "));
      System.out.println();

      // lambda可以使用静态,非静态,局部变量,这称为lambda的变量捕获
      // lambda又称闭包 或 匿名函数,
      System.out.println("I'm the local var in main:charNum, " + charNum);
    });
    System.out.println(languages.stream().collect(Collectors.joining()));
  }

  public void print() {
    System.out.println("this is a lambda instance");
  }
}
