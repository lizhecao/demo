package com.test.demo.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.regex.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * Created by ryan on 2017/6/22.
 */
@Getter
//@EqualsAndHashCode
public class Test {
  private int id;

  public static void main(String[] args) {
    short s1 = 1;
    s1 += 1;
    s1 = (short)(s1 + 1);

    // java 5 引入自动装箱、拆箱机制
    Integer i = 1;
    Float f = 2.1f;

    Integer a = new Integer(3);
    Integer b = 3;
    int c = 3;

    // integer 引用的不是同一个对象
    System.out.println(a == b);
    // 自动拆箱
    System.out.println(a == c);

    Integer f1 = 4;
    Integer f2 = 4;
    Integer f3 = 200;
    Integer f4 = 200;

    System.out.println(f4.hashCode());

    String s = "haha";
    // 如果整型字面量的值在-128到127之间，那么不会new新的Integer对象
    // 而是直接引用常量池中的Integer对象，所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
    System.out.println(f1 == f2);
    System.out.println(f3 == f4);

    System.out.println(false & in());

    System.out.println(Math.round(11.5));
    System.out.println(Math.round(-11.5));
    System.out.println(Math.round(-11.6));
    // switch not support long type
//    switch ((long)f1) {
//
//    }
    System.out.println(2 << 3);

    int x = 3;
    int y = 4;
    // swap without another var
    x ^= y;
    y ^= x;
    x ^= y;
    System.out.println("x=" + x + ";y=" + y);

    int[] array = {1, 2, 3};
    String[] strings = new String[]{"a", "b", "c"};

    String str = "hello";
    StringBuilder builder = new StringBuilder(str);
    builder.append("hehe");
    str.intern();

    Test.InnerClass innerClass = new Test().new InnerClass();
//    System.gc();
//    Runtime.getRuntime().gc();

    System.out.println(reverse("hello"));
    try {
      new String(str.getBytes("GB2312"), "ISO-8859-1");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.get(Calendar.YEAR);
    calendar.getTimeInMillis();
    FastDateFormat format = FastDateFormat.getInstance("yyyyMMDD");
    format.format(calendar.getTime());
    calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    calendar.add(Calendar.DATE, -1);

    System.out.println(testFinally());

    Collections.sort(new ArrayList<String>(), (o1, o2) -> 0);
    new Thread(new Runnable() {
      @Override
      public void run() {

      }
    }).yield(); // yield 方法将CPU让给其他优先级更高的线程，进入runnable状态

//    str.split()
    Pattern.matches(".", "abc");
    Pattern pattern = Pattern.compile("ab?");
    pattern.matcher("abc");

    Integer[] arr = {1, 2, 3, 4, 5};
    System.out.println(search(arr, 5));
  }

  public static boolean in() {
    System.out.println("in");
    return true;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }

  @Override
  public int hashCode() {
    final int PRIME = 31;
    return new HashCodeBuilder(this.getId() % 2 == 0 ? this.getId() + 1:this.getId(), PRIME).toHashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (o == this)
      return true;
    if (o.getClass() != getClass())
      return false;
    Test test = (Test)o;
    return new EqualsBuilder().append(this.getId(), test.getId()).isEquals();
  }

  public static boolean testFinally() {
    try {
      return true;
    }finally {
      System.out.println("finally");
    }
  }

  public static String reverse(String orginStr) {
    int size = 0;
    if (orginStr == null || (size = orginStr.length()) == 1) {
      return orginStr;
    }

    return orginStr.charAt(size - 1) + reverse(orginStr.substring(0, size - 1));
  }

  public static<T extends Comparable<T>> int search(T[] arr, T key) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (right + left) >>> 1;
      int result = arr[mid].compareTo(key);
      if (result == 0) {
        return mid;
      } else if (result > 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  public class InnerClass {

  }
}

// only one public class is allowed in a file
//public class Test2{
//
//}

interface Ha {

}
interface Ho {

}
// 接口支持多重继承
interface He extends Ha, Ho{

}