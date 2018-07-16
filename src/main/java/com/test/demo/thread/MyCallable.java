package com.test.demo.thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author lizhecao 2018/4/17
 * @version 1.0
 */
public class MyCallable implements Callable {
  private String taskNum;

  public MyCallable(String taskNum) {
    this.taskNum = taskNum;
  }

  @Override
  public Object call() throws Exception {
    System.out.println("start task >>> " + taskNum);
    Date startTime = new Date();
    Thread.sleep(1000);

    long time = new Date().getTime() - startTime.getTime();
    System.out.println("end task >>> " + taskNum);

    return taskNum + " cost " + time + "ms";
  }
}
