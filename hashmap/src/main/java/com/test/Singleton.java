package com.test;

/**
 * @description:
 * @author: 李哲操
 * @create: 2021-03-04 16:15
 **/
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

class Singleton2 {
    private static volatile Singleton2 singleton;

    private Singleton2() {
    }

    public static Singleton2 getSingleton() {
        if (null == singleton) {
            synchronized (singleton) {
                // double check 防止多线程环境下的竞争
                if (null == singleton) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}
