package com.test.hashmap;

/**
 * HashMap接口，定义HashMap 需要提供的基本操作
 *
 * @author lizhecao 2018/4/11
 * @version 1.0
 */
public interface MyHashMapInterface<K, V> {
  int length();

  /**
   * 插入键值对，如果已经存在key 则 替换它的值
   */
  void insert(K k, V v);
  V get(K k);
  //TODO: contain value?
  boolean contain(K k);
  void del(K k);

  void print();
}
