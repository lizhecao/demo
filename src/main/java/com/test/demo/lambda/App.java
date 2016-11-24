package com.test.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.test.demo.Person.Sex;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person p1 = new Person("ryan", 24, Sex.MALE, "541995149@qq.com");
        Person p2 = new Person("jobs", 29, Sex.MALE, "238292384@gmail.com");
        Person p3 = new Person("kaixuan", 26, Sex.FEMALE, "1923902392@qq.com");
        
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        
        
    }
}
