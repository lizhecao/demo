package com.test.demo.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import java.lang.reflect.Type;

/**
 * @author lizhecao 2017-10-25
 * @version 1.0
 */
public class MyGenericTest {
  public static <T> T test(Type t){
    String json = "{\"t\":{\"a\":1}}";
    return JSON.parseObject(json, t);
  }

  public static void main(String[] args) {
    // 暂时没发现什么方法可以来传入泛型类
    MyGenericType<MyGenericBody> g = null;
    g = test(new TypeReference<MyGenericType<MyGenericBody>>(){}.getType());
    System.out.println(g.getT().getA());
  }
}
