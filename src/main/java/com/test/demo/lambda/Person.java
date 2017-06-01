package com.test.demo.lambda;

public class Person {
  public enum Sex {
    MALE, FEMALE
  }

  String name;
  int age;
  Sex gender;
  String emailAddress;

  public Person(String name, int age, Sex gender, String emailAddress) {
    super();
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.emailAddress = emailAddress;
  }

  public void printPerson() {
    System.out.format("%s : age->%d, sex->%d, birthday->%s\n", name, age, gender, emailAddress);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Sex getGender() {
    return gender;
  }

  public void setGender(Sex gender) {
    this.gender = gender;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
}
