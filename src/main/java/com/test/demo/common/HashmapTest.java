package com.test.demo.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ryan on 2017/6/27.
 */
public class HashmapTest {
  public static final int THREAD_NUM = 5;

  public static void main(String[] args) throws InterruptedException {
    Map<String, Integer> map = new ConcurrentHashMap<>();
    System.out.println("concurrentHashMap:");
    test(map);
    Map<String, Integer> map1 = new Hashtable<>();
    System.out.println("hashtable:");
    test(map1);
    Map<String, Integer> map2 = Collections.synchronizedMap(new HashMap<>());
    System.out.println("synchronized hashmap:");
    test(map2);
  }

  public static void test(Map<String, Integer> map) throws InterruptedException {
    for (int k = 0; k < 5; k ++) {
      long startTime = System.currentTimeMillis();
      ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

      for (int i = 0; i < THREAD_NUM; i++) {
        executor.execute(() -> {
          for (int j = 0; j < 500000; j++) {
            Integer randomNum = (int) Math.ceil(Math.random() * 550000);
            String randStr = String.valueOf(randomNum);
            map.put(randStr, randomNum);
          }
        });
      }

      executor.shutdown();
      executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
      System.out.println("2500k msg add in " + (System.currentTimeMillis() - startTime) + " ms");
    }
  }
}
