package com.test.demo.jdbc;

import java.util.List;

/**
 * Created by ryan on 2017/6/1.
 */
public interface PersonDao {
  void addPerson(Person person);
  void deletePerson(int id);
  void updatePerson(Person person);
  Person queryPerson(int id);
  List<Person> queryPersons();
}
