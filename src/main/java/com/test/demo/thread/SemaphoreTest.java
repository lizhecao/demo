package com.test.demo.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by ryan on 2017/6/23.
 */
public class SemaphoreTest extends Thread {
  static Semaphore s = new Semaphore(2);

  public static void main(String[] args) {
    Thread t1 = new Thread(null, new SemaphoreTest(), "t1");
    Thread t2 = new Thread(null, new SemaphoreTest(), "t2");
    Thread t3 = new Thread(null, new SemaphoreTest(), "t3");

    t1.start();
    t2.start();
    t3.start();
  }

  @Override
  public void run() {
    try {
      while (true) {
        if (s.tryAcquire()) {
          System.out.println(Thread.currentThread().getName() + " is working");
          try {
            Thread.sleep(5000);
            break;
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } else {
          System.out.println("lock is held by other thread, " + Thread.currentThread().getName() +
              " will work something else and try after 2 seconds");
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    } finally {
      System.out.println(Thread.currentThread().getName() + " is done");
      s.release();
    }
  }
}
