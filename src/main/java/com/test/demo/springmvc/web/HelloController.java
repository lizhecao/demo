package com.test.demo.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ryan on 2017/6/9.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
  @RequestMapping(method = RequestMethod.GET)
  public String sayHello(ModelMap model) {
    model.addAttribute("message", "hello");
    return "hello";
  }
}
