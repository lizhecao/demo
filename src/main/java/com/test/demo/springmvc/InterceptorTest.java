package com.test.demo.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * spring mvc 拦截器
 * Created by ryan on 2017/6/13.
 */
public class InterceptorTest extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
    System.out.println("before handle");
    return super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println("after handle");
    super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    System.out.println("after complete");
    super.afterCompletion(request, response, handler, ex);
  }
}
