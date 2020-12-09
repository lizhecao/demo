package com.test.demo.spring.sessionScopeBeanTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 李哲操
 * @create: 2020-07-02 20:50
 **/
@RestController
public class Hello {
    @Autowired
    SingleTonAutoWireSessionBean singleTonAutoWireSessionBean;

    @RequestMapping("/")
    @ResponseBody
    public String sayHello() {
        singleTonAutoWireSessionBean.getSessionScopeBean().sayHello();
        return "hello";
    }
}
