package com.test.demo.config;
/**
 * @Date 2016年12月6日 上午9:42:56
 * @author ryan
 * @version 1.0
 * @since JDK 1.8
 */

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigObject;

public class Main {
  public static void main(String[] args) {
    Config conf = ConfigFactory.load("app");
    Config test = conf.getConfig("Test");
    System.out.println("name:" + test.getString("name"));
    System.out
        .println("path:" + ConfigFactory.defaultOverrides().withFallback(conf.getConfig("path")).getString("path"));
    conf.getList("version").forEach(x -> System.out.println(x.unwrapped()));

    Config conf1 = ConfigFactory.load("app2");
    Config conf2 = ConfigFactory.load("app1");
    Config conf12 = conf1.withFallback(conf2);

    System.out.println("name:" + conf12.getString("Test.name"));
    System.out.println("version:" + conf12.getDouble("app.version"));

    ConfigObject confObject = conf12.getObject("Test");
    System.out.println(confObject.render());
    confObject.forEach((k, v) -> System.out.println("key:" + k + ", value:" + v.unwrapped()));
  }
}
