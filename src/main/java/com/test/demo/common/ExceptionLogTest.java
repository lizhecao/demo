package com.test.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lizhecao 2019/2/25
 * @version 1.0
 */
public class ExceptionLogTest {
  private static Logger logger = LoggerFactory.getLogger(ExceptionLogTest.class);
  public static void main(String[] args) {
    try {
//      Test test = null;
//      test.toString();
      throw new Exception("haha");
    } catch (Exception e) {
      logger.error("hello, {}", e);
    }
  }
}
