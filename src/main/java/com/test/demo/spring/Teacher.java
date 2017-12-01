package com.test.demo.spring;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ryan on 2017/6/6.
 */
@Getter
@ToString
@Component
public class Teacher {
  private String id;
  private String name;
//  @Autowired
//  private List<Student> students;
//  @Autowired
//  private Map<String, Student> studentMap;
}
