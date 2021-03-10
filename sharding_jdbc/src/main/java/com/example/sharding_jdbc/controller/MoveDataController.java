package com.example.sharding_jdbc.controller;

import com.example.sharding_jdbc.entity.Order;
import com.example.sharding_jdbc.mapper.OrderMapper;
import com.example.sharding_jdbc.service.OrderMapper1Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lizhecao 2020/12/13
 * @version 1.0
 */
@RestController
@RequestMapping("move")
public class MoveDataController {
  // 新服务上线后的老库中的最新id
  public static final long FIRST_ID_AFTER_NEW_SERVICE = 544866008138493953L;
  @Autowired
  private OrderMapper orderMapper;
  @Autowired
  private OrderMapper1Manage orderMapper1Manage;

  @GetMapping
  public void move() {
    int step = 1;
    for (int i = 0; ; i += step) {
      // 一次取一条数据
      List<Order> orders = orderMapper.select(i, step);
      for (Order order : orders) {
        System.out.println("取出数据:" + order);
        try {
          orderMapper1Manage.insertSelective(order);
        } catch (DuplicateKeyException e) {
          // 重复键异常说明老数据迁移完成了，可以结束任务了
          e.printStackTrace();
          System.out.println("迁移完成");
          return;
        }
      }
      // 然后先等一等，方便我模拟这时候插入其他数据的情况
      try {
        Thread.currentThread().sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
