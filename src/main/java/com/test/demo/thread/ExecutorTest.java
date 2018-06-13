package com.test.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by ryan on 2017/6/20.
 */
public class ExecutorTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // executor 及它的子类实现了线程池，解耦了任务 和 任务的执行
    // executors 创建线程池的工具类，想要自定义用ThreadPoolExecutor
    // executor 接口只提供了execute方法，用来提交任务
    // executorService方法 继承并提供了submit方法，可以获取执行结果Future，通过Future可以get阻塞获取结果
    // 或者 shutdown控制线程池等
    Executor executor = Executors.newSingleThreadExecutor();
    executor.execute(() -> {});
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    // 通过callable回调函数返回结果
    executorService.submit(() -> null);
    // 不再添加新任务(关闭线程池了)
    executorService.shutdown();


    ExecutorService executorService1 = Executors.newCachedThreadPool();
    int totalTaskNum = 1000;

    // store the result
    List<Future> list = new ArrayList<>(totalTaskNum);
    for (int i = 0; i < totalTaskNum; i ++) {
      Future future = executorService1.submit(new MyCallable("" + i));
      list.add(future);
    }

    // get and print the result
    for (int i = 0; i < totalTaskNum; i++) {
      System.out.println(list.get(i).get());
    }
  }
}
