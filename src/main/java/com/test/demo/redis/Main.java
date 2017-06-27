package com.test.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by ryan on 2017/6/20.
 */
public class Main {

  static Jedis jedis = new Jedis("172.16.0.248");

  public static void main(String[] args) {
//    testString();
//    testList();
    testSubscribe();
  }

  public static void testString() {
    jedis.set("foo", "bar");
    System.out.println(jedis.get("foo"));

    jedis.expire("foo", 5);

    while (jedis.exists("foo")) {
      System.out.println(jedis.ttl("foo"));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(jedis.ttl("foo"));
  }

  public static void testList() {
    jedis.rpush("friends", "Alice");
    jedis.rpush("friends", "Bob");
    jedis.lpush("friends", "Sam");

    jedis.lrange("friends", 0, -1).forEach(System.out::println);
  }

  public static void testSubscribe() {
    jedis.subscribe(new JedisPubSub() {
      @Override
      public void onMessage(String channel, String message) {
        super.onMessage(channel, message);
        System.out.println(channel + " get message: " + message);
      }

      @Override
      public void onPMessage(String pattern, String channel, String message) {
        super.onPMessage(pattern, channel, message);
      }

      @Override
      public void onSubscribe(String channel, int subscribedChannels) {
        super.onSubscribe(channel, subscribedChannels);
        System.out.println(channel + " is subscribed :" + subscribedChannels);
      }

      @Override
      public void onUnsubscribe(String channel, int subscribedChannels) {
        super.onUnsubscribe(channel, subscribedChannels);
        System.out.println(channel + " is unsubscribed :" + subscribedChannels);
      }

      @Override
      public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
      }

      @Override
      public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
      }

      @Override
      public void onPong(String pattern) {
        super.onPong(pattern);
      }
    }, "channel1");
  }
}
