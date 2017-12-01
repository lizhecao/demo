package com.test.demo.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhecao on 2017-8-30.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Service1 {
  @RequestMapping("/")
  public String home() {
    return "hello spring cloud";
  }

  public static void main(String[] args) {
    SpringApplication.run(Service1.class);
  }
}
