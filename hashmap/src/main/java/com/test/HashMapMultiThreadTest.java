package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * hashmap 多线程非安全测试
 * @author lizhecao 2019/3/13
 * @version 1.0
 */
public class HashMapMultiThreadTest {
  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < 100000; i++) {
      MyThread myThread = new MyThread(map, "线程" + i);
      myThread.start();
    }
  }
  static class MyThread extends Thread {
    public Map map;
    public String name;

    public MyThread(Map map, String name) {
      this.map = map;
      this.name = name;
    }

    public void run() {
      map.put(1, 1);
      map.remove(1);
      try {
        this.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name + " 系统时间：" + System.currentTimeMillis() + " size=" + map.size());
    }
  }
}
