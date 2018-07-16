package com.test.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 每个代理对象 内部都有一个实现了InvocationHandler接口的 类的实例
 *
 * InvocationHandler 顾名思义就是 代理对象的方法调用的处理类(调用它的invoke方法)
 *
 * @author lizhecao 2018/4/19
 * @version 1.0
 */
public class InvocationHandlerImpl implements InvocationHandler {
  // 目标对象
  private Object target;

  public InvocationHandlerImpl(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 代理方法简单地打下日志，这其实就是spring aop的简单实现
    System.out.println("start");

    // 调用目标对象的实际方法
    Object result = method.invoke(target, args);

    System.out.println("end");

    return  result;
  }

  /**
   * 通过Proxy.newProxyInstance 生成代理对象（重要的方法）
   */
  public Object getProxy() {
    return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
        target.getClass().getInterfaces(), this);
  }

  public static void main(String[] args) {
    // 实例化目标对象
    User user = new UserImpl();

    // 用目标对象实例化InvocationHandler
    InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(user);

    // 生成代理对象
    User proxyUser = (User) invocationHandler.getProxy();

    // 调用代理对象的方法，实际上就是调用了invocationHandler的invoke方法
    proxyUser.sayHello();
  }
}
