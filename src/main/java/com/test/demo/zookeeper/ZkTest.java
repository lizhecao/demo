package com.test.demo.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

/**
 * @description:
 * @author: 李哲操
 * @create: 2020-11-27 11:02
 **/
public class ZkTest {
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("zookeeper.dev.vivo.xyz:2183");
        zkClient.createPersistent("/lizhecao/test");
        System.out.println(zkClient.getChildren("/lizhecao"));
    }
}
