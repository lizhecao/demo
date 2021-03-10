package com.example.feign_test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lizhecao 2020/12/26
 * @version 1.0
 */
@FeignClient(name = "hello", url = "hello", configuration = FeignInterceptor.class)
public interface HelloFeign {
  @PostMapping("test")
  void test(@RequestBody ConcreteData data);

  @PostMapping(value = "testForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  void testForm(@RequestBody ConcreteData data);
}
