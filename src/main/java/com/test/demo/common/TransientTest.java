package com.test.demo.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by ryan on 2017/6/22.
 */
public class TransientTest {

  public static void main(String[] args) {
    User user = new User();
    user.setUsername("ryan");
    user.setPassword("hello123");
    user.setSex("man");
    try {
      ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("test.txt"));
      output.writeObject(user);

      output.flush();
      output.close();

      // modify static username
      user.setUsername("bruce");

      ObjectInputStream input = new ObjectInputStream(new FileInputStream("test.txt"));
      User userAfterSerial = (User)input.readObject();
      System.out.println(userAfterSerial.getSex());
      System.out.println(userAfterSerial.getUsername());
      System.out.println(userAfterSerial.getPassword());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
