package com.test.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock相比synchronized更加灵活，可以通过trylock判断锁是不是被占用了，在被占用的情况下可以忙其他事，而不是直接就阻塞了
 * Created by ryan on 2017/6/20.
 */
public class LockTest implements Runnable {
  static ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {
    Thread t1 = new Thread(null, new LockTest(), "t1");
    Thread t2 = new Thread(null, new LockTest(), "t2");
    Thread t3 = new Thread(null, new LockTest(), "t3");

    t1.start();
    t2.start();
    t3.start();
  }

  @Override
  public void run() {
    try {
      while (true) {
        if (lock.tryLock()) {
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
      lock.unlock();
    }
  }
}
