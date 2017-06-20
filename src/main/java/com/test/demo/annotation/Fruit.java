package com.test.demo.annotation;

import java.lang.reflect.Field;
import lombok.ToString;

/**
 * Created by ryan on 2017/6/13.
 */
@ToString
public class Fruit {
  @FruitName("apple")
  private String name;
  @FruitColor
  private String color;

  public static void main(String[] args) {
    Fruit fruit = new Fruit();

    Field[] fields = fruit.getClass().getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(FruitName.class)) {
        FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
        System.out.println("fruitName: " + fruitName.value());
      }
      if (field.isAnnotationPresent(FruitColor.class)) {
        FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
        System.out.println("fruitColor: " + fruitColor.value());
      }
    }
  }
}
