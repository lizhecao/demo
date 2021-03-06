package com.test.demo.spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Created by ryan on 2017/6/6.
 */
@Getter
@ToString
@AllArgsConstructor
public class Student {
  private String id;
  private String name;
}
