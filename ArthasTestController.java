/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.test.Student
 */
package com.test;

import com.test.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ArthasTestController {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ArthasTestController.class, args);
    }

    @GetMapping(value={"name"})
    public Student getUserInfo() {
        return new Student("1", "小明");
    }
}

