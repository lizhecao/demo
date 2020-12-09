package com.test.demo.spring.sessionScopeBeanTest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 李哲操
 * @create: 2020-07-02 14:48
 **/
@Component
@Data
public class SingleTonAutoWireSessionBean {
    @Autowired
    private SessionScopeBean sessionScopeBean;
}
