package com.test.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by lizc22 on 2017-7-18.
 */
public class MyEvent extends ApplicationEvent {

  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  public MyEvent(Object source) {
    super(source);
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-base.xml");
    HelloBean helloBean = (HelloBean)ctx.getBean("helloBean");
    helloBean.setName("hello, myevent happen");
  }
}


// 实现各种xxxAware方法来获得各种xxx资源
@Component
class HelloBean implements ApplicationContextAware {
  private ApplicationContext applicationContext;
  private String name;
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  // 通过容器发布事件，将bean作为消息源传进去
  public  void setName(String name) {
    this.name = name;
    applicationContext.publishEvent(new MyEvent(this));
  }

  public String getName() {
    return name;
  }
}


// 自定义监听器，监听MyEvent事件
@Component
class MyApplicationListener implements ApplicationListener {

  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    if (event instanceof MyEvent) {
      System.out.println(((HelloBean)event.getSource()).getName());
    }
  }
}