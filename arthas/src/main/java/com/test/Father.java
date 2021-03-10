package com.test;

/**
 * @description:
 * @author: 李哲操
 * @create: 2021-02-05 17:26
 **/
public class Father {
    public void test() {
        System.out.println(this.a());
    }

    public String a() {
        return "Father";
    }
}
