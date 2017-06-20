package com.test.demo.springmvc.web;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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


  @RequestMapping("{userName}")
  public String sayHelloToWho(@PathVariable String userName, @RequestHeader Map<String, String> header,  Model model) {
    header.forEach((x, y) -> {
      System.out.println(x + ": " + y);
    });
    model.addAttribute("userName", userName);
    return "sayhello";
  }
}
