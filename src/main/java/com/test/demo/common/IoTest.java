package com.test.demo.common;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import lombok.Getter;

/**
 * Created by ryan on 2017/6/22.
 */
@Getter
public class IoTest implements Cloneable {
  static {
    System.out.println("static block");
  }
  private String name;

  private String s;
  private int i;

  public IoTest(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
//    bufferReadTest();
//    resourceLoaderTest();
    IoTest ioTest = new IoTest("hello");
    try {
      IoTest newIo = (IoTest)ioTest.clone();
      System.out.println(newIo.getName());
      System.out.println(newIo.getName() == ioTest.getName());
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    System.out.println(ioTest.getI());
    System.out.println(ioTest.getS());
  }

  public static void commonReadTest(String source, String target) throws IOException {
    try (FileInputStream input = new FileInputStream(source)) {
      try (FileOutputStream output = new FileOutputStream(target)) {
        byte[] bytes = new byte[4096];
        int byteToRead;
        while ((byteToRead = input.read(bytes)) != -1) {
          output.write(bytes, 0, byteToRead); // 要从输入中获取要读到的字节数
        }
      }
    }
  }

  public static void bufferReadTest() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("E:\\java\\demo\\src\\main\\resources\\app.conf"));
      String line = reader.readLine();

      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void resourceLoaderTest() {
    try {
      InputStream inputStream = Class.forName("com.test.demo.common.IoTest").getResourceAsStream("/app.conf");
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line = reader.readLine();
      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void dateInputStreamTest() {
    try {
      InputStream inputStream = Class.forName("com.test.demo.common.IoTest").getResourceAsStream("/app.conf");
      DataInputStream input = new DataInputStream(inputStream);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
