package com.test.demo.spring;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author lizhecao 2017-9-8
 * @version 1.0
 */
abstract class AbstractClass {
  @Value("${server.port}")
  private String port;

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }
}
