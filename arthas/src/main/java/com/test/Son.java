package com.test;

import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: 李哲操
 * @create: 2021-02-05 17:26
 **/
public class Son extends Father {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Father father = new Son();
        father.getClass().getMethod("test", new Class[0]).invoke(father);
        father.test();
    }

    public String a() {
        return "Son";
    }
}
