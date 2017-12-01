package com.example.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lizhecao on 2017-8-31.
 */
@Service
public class HelloService {
  @Autowired
  RestTemplate restTemplate;

  public String hello(String name) {
    return restTemplate.getForObject("http://SERVICE-HI?name=" + name, String.class);
  }
}
