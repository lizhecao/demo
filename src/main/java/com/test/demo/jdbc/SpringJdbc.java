package com.test.demo.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ryan on 2017/6/1.
 */
public class SpringJdbc {

  public static void main(String[] args) {
    ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
//    PersonDao personDao = (PersonDao)appCtx.getBean("personDaoImpl");
//    Person p1 = new Person();
//    p1.setId(3);
//    p1.setName("bruce");
//
//    personDao.addPerson(p1);
//    System.out.println(personDao.queryPerson(1).toString());
//    personDao.queryPersons().forEach(x -> System.out.println(x.toString()));
    PersonService personService = (PersonService) appCtx.getBean("personServiceImpl");
    Person p1 = new Person();
//    p1.setId(5);
//    p1.setName("merlin");
    personService.addPerson(p1);
  }
}
