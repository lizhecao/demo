package com.test.demo.spring;

import java.io.PrintStream;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

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
  public String hello() {
    System.out.println("hello");
    try {
      TimeUnit.SECONDS.sleep(60);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "hello";
  }

  public static void main(String[] args) {
    Base64.getDecoder().decode("fzIycHEPJXpPNQNtJnByYzJ7Jvf620bJs+n2X09uhfiltf9PoTyomYVnt4WmkLXn9K3gJ989Zit90n4BaH8tJnxvJXovciwtKRIuZTJ7amUtaR89ZdxvJXovciwtKRIybicvZWCB3n690n4BaHwx");
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
