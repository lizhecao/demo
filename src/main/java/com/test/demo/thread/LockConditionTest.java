package com.test.demo.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ryan on 2017/6/29.
 */
public class LockConditionTest {

  public static void main(String[] args) {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition1 = lock.newCondition();
    final int size = 5;
    Queue queue = new ArrayDeque(size);

    new Thread(new Producer2(lock, condition, queue, size)).start();
    new Thread(new Consumer2(lock, condition, queue, size)).start();
    // 由于Producer中唤醒的是condition，所以这个condition1的await一次之后就再也醒不过来了
    new Thread(new Consumer2(lock, condition1, queue, size)).start();
  }
}

class Consumer2 implements Runnable {
  private ReentrantLock lock;
  private Condition condition;
  private Queue<Integer> queue;
  private int size;

  public Consumer2(ReentrantLock lock, Condition condition, Queue<Integer> queue, int size) {
    this.lock = lock;
    this.condition = condition;
    this.queue = queue;
    this.size = size;
  }

  @Override
  public void run() {
    try {
      lock.lock();
      while(true) {
        if (queue.size() > 0) {
          System.out.println("Consumer " + Thread.currentThread().getName() + " consume: " + queue.remove());
          condition.signal();
        } else {
          try {
            condition.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    } finally {
      lock.unlock();
    }
  }
}

class Producer2 implements Runnable {
  private ReentrantLock lock;
  private Condition condition;
  private Queue<Integer> queue;
  private int size;

  public Producer2(ReentrantLock lock, Condition condition, Queue<Integer> queue, int size) {
    this.lock = lock;
    this.condition = condition;
    this.queue = queue;
    this.size = size;
  }

  @Override
  public void run() {
    try {
      lock.lock();
      while(true) {
        if (queue.size() < size - 1) {
          int rand = new Random().nextInt(100);
          queue.offer(rand);
          System.out.println("Producer " + Thread.currentThread().getName() + " produce: " + rand);
          condition.signal();
        } else {
          try {
            condition.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    } finally {
      lock.unlock();
    }
  }
}