package com.test.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.Getter;

/**
 * Created by ryan on 2017/6/1.
 */
public class SimpleJdbc {
  @Resource
  @Getter
  private DataSource dataSource;

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;

    try {
//      // Register JDBC Driver
//      Class.forName("com.mysql.jdbc.Driver");
//
//      // open Connection
//      conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "hello123");
//
//      // createStatement
//      stmt = conn.createStatement();

      conn = new SimpleJdbc().getDataSource().getConnection();

      // sql
      String sql = "select * from person";

      stmt = conn.prepareStatement(sql);

      // excuteStatement
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        System.out.println(id + " | " + name);
      }

      // clean up
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
