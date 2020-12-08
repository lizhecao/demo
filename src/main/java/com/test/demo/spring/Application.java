package com.test.demo.spring;

import java.io.PrintStream;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizc22 on 2017-7-18.
 */
@RestController
@EnableAutoConfiguration
public class Application {

  @RequestMapping("/")
  public void hello() {
    System.out.println("hello");
  }

  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(Application.class);
    springApplication.setBanner(new Banner() {
      @Override
      public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println("hello I'm spring boot banner");
        out.println("my version is v1.4.3");
      }
    });

    System.out.println("test");
  }
}
