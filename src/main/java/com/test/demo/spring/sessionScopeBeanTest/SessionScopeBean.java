package com.test.demo.spring.sessionScopeBeanTest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @description: 研究Scope为session、request的原理
 * @author: 李哲操
 * @create: 2020-07-02 14:48
 **/
@Component
@SessionScope
public class SessionScopeBean {

    public void sayHello() {
        System.out.println("hello");
    }
}
