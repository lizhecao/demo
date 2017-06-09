package com.test.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by ryan on 2017/6/2.
 */
@Aspect
@Component
public class AnnotationAspectTest {
  @Pointcut("execution(* com.test.demo.aop.*Service.hello2(..)) && args(test, ..)")
  private void pointCut(String test) {}

  @Pointcut("bean(*ServiceImpl) && args(a1, a2, ..)")
  private void pointCut2(String a1, String a2) {}

//  @Before("pointCut(test)")
//  public void before(JoinPoint jp, String test) {
//    System.out.println("before ...");
//    System.out.println("args:" + jp.getArgs() + "\nproxy object:" + jp.getThis().getClass() + "\ntarget object:" + jp.getTarget().getClass()
//      + "\nsignature:" + jp.getSignature() + "\ndescription:" + jp.toString());
//
//    System.out.println("the parameter: " + test);
//  }

  @Before("pointCut2(a1, a2)")
  public void before2(JoinPoint jp, String a1, String a2) {
    System.out.println("before ...");
    System.out.println("args:" + jp.getArgs() + "\nproxy object:" + jp.getThis().getClass() + "\ntarget object:" + jp.getTarget().getClass()
        + "\nsignature:" + jp.getSignature() + "\ndescription:" + jp.toString());

    System.out.println("the parameter: " + a1 + " | " + a2);
  }

  @After("pointCut(test)")
  public void after(String test) {
    System.out.println("after ...");
  }

  @AfterReturning(pointcut = "pointCut(test)", returning = "retVal")
  public void afterReturning(Object retVal, String test) {
    System.out.println("the parameter: " + test);

    System.out.println("get Result:" + retVal.toString());
  }

  @Around("pointCut(test)")
  public String around(ProceedingJoinPoint pjp, String test) throws Throwable {
    System.out.printf("before...");
    Object retVal = pjp.proceed(new Object[]{test});
    System.out.println("get Result:" + retVal.toString());
    System.out.println("after...");
    return retVal.toString();
  }
}
