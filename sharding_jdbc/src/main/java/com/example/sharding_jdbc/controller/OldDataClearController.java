package com.example.sharding_jdbc.controller;

import com.example.sharding_jdbc.entity.Order;
import com.example.sharding_jdbc.mapper.OrderMapper;
import com.example.sharding_jdbc.service.OrderMapper1Manage;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("clear")
public class OldDataClearController {
  // 新服务上线后的老库中的最新id
  public static final long FIRST_ID_AFTER_NEW_SERVICE = 544880584108257281l;
  @Autowired
  private OrderMapper orderMapper;
  @Autowired
  private OrderMapper1Manage orderMapper1Manage;

  @GetMapping
  public void clear() {
    int step = 1;
    for (int i = 0; ; i += step) {
      // 一次取一条数据
      List<Order> orders = orderMapper.select(i, step);
      if (CollectionUtils.isEmpty(orders)) {
        return;
      }
      for (Order order : orders) {
        if (order.getOrderId() <= FIRST_ID_AFTER_NEW_SERVICE) {
          if (order.getUserId() % 4 > 1) {
            orderMapper.deleteByOrderIdNUserId(order.getUserId(), order.getOrderId());
          }
        } else {
          // 当数据id大于新服务上线后的最新id，就停止了
          return;
        }
      }
    }
  }
}
