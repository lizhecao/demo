package com.example.eurekaclient;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lizhecao 2019/4/3
 * @version 1.0
 */
public class TokenPreFilter extends ZuulFilter{
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    System.out.printf("token filer ---> %s, %s\n",request.getMethod(), request.getRequestURL().toString());
    if (request.getParameter("token") != null) {
      ctx.setSendZuulResponse(true);
    } else {
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(400);
      ctx.setResponseBody("token is empty");
      ctx.set("isSuccess", false);
    }

    return null;
  }
}
