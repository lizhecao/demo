package com.example.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhecao on 2017-8-31.
 */
@RestController
public class HelloController {
  @Autowired
  HelloService helloService;

  @RequestMapping("/")
  public String helloribbon(String name) {
    return helloService.hello(name);
  }
}
