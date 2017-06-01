package com.test.demo;

import java.lang.reflect.Method;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Date 2016年12月5日 上午11:59:39
 * @author ryan
 * @version 1.0
 * @since JDK 1.8
 */
public class App extends Object {
  public static void main(String[] args) throws InterruptedException {
    App app = new App();
    A a = app.new A(1);
    B b = app.new B(1, 2);

    print(a);
    System.out.println("中文.....");
    print(b);

    final Clock clock = Clock.system(ZoneId.of("UTC+08:00"));
    System.out.println(clock.instant());
    System.out.println(clock.millis());
    System.out.println(LocalDateTime.now(clock));
    System.out.println(LocalDateTime.now());
    System.out.println(ZonedDateTime.now());
    System.out.println(ZonedDateTime.now(clock));

    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    System.out.println(engine.getClass().getName());
    try {
      System.out.println("js:" + engine.eval("function f(a, b){return a + b;}; f(2, 4);"));
    } catch (ScriptException e) {
      e.printStackTrace();
    }

    try {
      for (Method method : Class.forName("com.Test.demo.App").getMethods()) {
        System.out.println(method.getModifiers() + " " + method.getReturnType().getName() + " " + method.getName());
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void print() {
    System.out.println("haha");
  }

  public static void print(A a) {
    a.print();
    a.printA();
    if (a instanceof B) {
      ((B) a).printB();
    }
  }

  public class A {
    private int a;

    public A(int a) {
      this.a = a;
    }

    public void print() {
      System.out.println("A:" + a);
    }

    public void printA() {
      System.out.println("A:" + a);
    }

    public int getA() {
      return a;
    }

    public void setA(int a) {
      this.a = a;
    }
  }

  public class B extends A {
    public B(int a, int b) {
      super(a);
      this.b = b;
    }

    private int b;

    public void print() {
      System.out.println("B:" + b);
    }

    public void printB() {
      System.out.println("B:" + b);
    }

    public int getB() {
      return b;
    }

    public void setB(int b) {
      this.b = b;
    }
  }
}

