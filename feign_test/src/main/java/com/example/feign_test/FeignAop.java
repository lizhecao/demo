package com.example.feign_test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lizhecao 2020/12/27
 * @version 1.0
 */
@Component
@Aspect
public class FeignAop {
  @Pointcut(value = "execution(* com.example.feign_test.HelloFeign.*(..))")
  private void pointCut() {}

  @Around("pointCut()")
  public String around(ProceedingJoinPoint pjp, Object[] args) throws Throwable {
    System.out.printf("before...");
    PostMapping signature = (PostMapping) pjp.getSignature();
    if (signature.value()[0].contains("hhaa")) {
      System.out.println("good");
    }
    Object retVal = pjp.proceed(args);
    System.out.println("get Result:" + retVal.toString());
    System.out.println("after...");
    return retVal.toString();
  }
}
