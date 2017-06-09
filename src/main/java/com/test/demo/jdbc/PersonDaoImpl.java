package com.test.demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by ryan on 2017/6/1.
 */
@Repository
public class PersonDaoImpl implements PersonDao {
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public void addPerson(Person person) {
//    jdbcTemplate.update("insert into person (id, name) values (?, ?)", person.getId(), person.getName());
    throw new RuntimeException("exp here");
  }

  @Override
  public void deletePerson(int id) {

  }

  @Override
  public void updatePerson(Person person) {

  }

  @Override
  public Person queryPerson(int id) {
    // orm 框架搞定这些
    return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id}, new PersonMapper());
  }

  @Override
  public List<Person> queryPersons() {
    return jdbcTemplate.query("select * from person", new PersonMapper());
  }

  public static final class PersonMapper implements RowMapper<Person> {

    // orm框架干的就是这事
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
      Person person = new Person();
//      person.setId(resultSet.getInt("id"));
//      person.setName(resultSet.getString("name"));
      return person;
    }
  }
}
