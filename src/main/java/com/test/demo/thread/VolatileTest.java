package com.test.demo.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ryan on 2017/6/22.
 */
public class VolatileTest {
  private String value = "";
  private Boolean hasValue = false;
  public void produce(String value) {
    while (hasValue) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Producing " + value + " as the next consumable");
    this.value = value;
    hasValue = true;
  }
  public String consume() {
    while (!hasValue) {
      try {
        Thread.sleep(1000);
        System.out.println("I'm still here");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("I'm stop");
    String value = this.value;
    hasValue = false;
    System.out.println("Consumed " + value);
    return value;
  }

  public void stop() {
    System.out.println(hasValue);
    hasValue = true;
    System.out.println(hasValue);
  }

  public static void main(String[] args) {
    VolatileTest volatileTest = new VolatileTest();
    List<Integer> values = new ArrayList<>();
    for(int i = 0;i < 1000; i ++) {
      values.add(i);
    }
    Thread consumer = new Thread(() -> volatileTest.consume());
    consumer.start();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("ask the consumer to stop");
    new Thread(() -> volatileTest.stop()).start();
  }
}
