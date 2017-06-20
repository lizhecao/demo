package com.test.demo.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 读写锁测试
 * 读锁可以由多个线程保持
 * 写锁是独占的
 * 所以只要读写、写写互斥
 * Created by ryan on 2017/6/20.
 */
public class ReadWriteLockTest {
  static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

  public static void main(String[] args) {
    Thread t1 = new MyThread("t1", 0);
    Thread t2 = new MyThread("t1", 0);
    Thread t3 = new MyThread("t1", 1);

    t1.start();
    t2.start();
    t3.start();
  }

  private static class MyThread extends Thread {
    private int type;

    public MyThread(String name, int type) {
      super(name);
      this.type = type;
    }

    @Override
    public void run() {
      if (this.type == 0) {
        ReadLock readLock = lock.readLock();
        try {
          readLock.lock();

          System.out.println("to read... " + this.getName());
          try {
            sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } finally {
          readLock.unlock();
        }
      } else {
        WriteLock writeLock = lock.writeLock();
        try {
          writeLock.lock();

          System.out.println("to write... " + this.getName());
          try {
            sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } finally {
          writeLock.unlock();
        }
      }
    }
  }
}
