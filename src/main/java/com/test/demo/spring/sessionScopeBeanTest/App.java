package com.test.demo.spring.sessionScopeBeanTest;

import com.test.demo.spring.InspectAbstractTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2017/1/4.
 */
@SpringBootApplication
@ComponentScan("com.test.demo.spring.sessionScopeBeanTest")
public class App {
  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(App.class, args);
    // 这样去获取session Bean是不行的，因为没有在request请求中的话，在获取RequestAttributes的时候就会为空
//    SingleTonAutoWireSessionBean singleTonAutoWireSessionBean = (SingleTonAutoWireSessionBean) ctx.getBean("singleTonAutoWireSessionBean");
//    singleTonAutoWireSessionBean.getSessionScopeBean().sayHello();
  }
}
