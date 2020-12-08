package com.test.demo.spring.session;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lizhecao 2019/4/11
 * @version 1.0
 */
@RestController
@RequestMapping("/spring/session")
public class SpringSessionTestController {
  @RequestMapping("/putIntoSession")
  public String putIntoSession(HttpServletRequest request, String username) {
    request.getSession().setAttribute("name",  "leo");
    return "ok";
  }

  @RequestMapping("/getFromSession")
  public String getFromSession(HttpServletRequest request){
    String name = (String) request.getSession().getAttribute("name");
    return name;
  }
}
