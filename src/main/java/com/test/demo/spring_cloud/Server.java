package com.test.demo.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by lizhecao on 2017-8-30.
 */
@SpringBootApplication
@EnableEurekaServer
public class Server {

  public static void main(String[] args) {
    SpringApplication.run(Server.class, args);
  }
}
