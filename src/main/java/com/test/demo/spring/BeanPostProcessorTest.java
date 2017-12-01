package com.test.demo.spring;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * bean生成的顺序为 定义 --> 创建 --> 初始化
 * Created by lizc22 on 2017-7-18.
 */
@Component
public class BeanPostProcessorTest implements BeanDefinitionRegistryPostProcessor{

  // BeanDefinitionRegistry的postProcessBeanDefinitionRegistry方法用来在BeanDefinition被加载之后，但是
  // Bean还没创建之前调用
  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
      throws BeansException {
    System.out.println("postProcessBeanDefinitionRegistry");
  }

  // 该方法来自BeanFactoryPostProcessor,postProcessBeanFactory用来在Bean创建之后，初始化之前做一些操作
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    System.out.println("postProcessBeanFactory");
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-base.xml");
  }
}

@Component
class TestA {
  // postConstruct注解的方法在bean初始化后首先被调用
  @PostConstruct
  public void init() {
    System.out.println("TestA PostConstruct");
  }

  @Resource
  private TestB testB;
}

@Component
class TestB {
  @PostConstruct
  public void init() {
    System.out.println("TestB PostConstruct");
  }

  @Resource
  private TestA testA;
}

// 自定义bean处理器
@Component
class MyBeanPostProcessor implements BeanPostProcessor {
  // 在bean初始化之前被调用，可以对bean做一些处理，例如返回代理bean
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (bean instanceof TestA || bean instanceof TestB) {
      System.out.println("postProcessBeforeInitialization");
    }
    return bean;
  }

  // 在bean初始化之后被调用，可以对bean做一些处理
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof TestA || bean instanceof TestB) {
      System.out.println("postProcessAfterInitialization");
    }
    return bean;
  }
}
