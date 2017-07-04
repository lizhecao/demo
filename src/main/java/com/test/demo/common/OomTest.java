package com.test.demo.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 2017/7/3.
 */
public class OomTest {
  static class OomObject {

  }

  public static void main(String[] args) {
    List<OomObject> oomObjects = new ArrayList<>();
    while (true) {
      oomObjects.add(new OomObject());
    }
  }
}
