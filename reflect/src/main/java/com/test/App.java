package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) throws IOException, ClassNotFoundException,
      NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
    File file = new File("/Users/lizhecao/java/demo/reflect/src/main/resources/spring.txt");
    FileInputStream inputStream = new FileInputStream(file);
    Properties springConfig = new Properties();
    springConfig.load(inputStream);

    String className = springConfig.getProperty("class");
    String methodName = springConfig.getProperty("method");
    Class classz = Class.forName(className);
    Method method = classz.getMethod(methodName);
    Object obj = classz.newInstance();
    method.invoke(obj);
  }
}
