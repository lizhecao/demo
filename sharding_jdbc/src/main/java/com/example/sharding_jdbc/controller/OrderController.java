package com.example.sharding_jdbc.controller;

import com.example.sharding_jdbc.entity.Order;
import com.example.sharding_jdbc.mapper.OrderMapper;
import com.example.sharding_jdbc.mapper.OrderMapper1;
import com.example.sharding_jdbc.service.OrderMapper1Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lizhecao 2020/12/9
 * @version 1.0
 */
@RestController
@RequestMapping("order")
public class OrderController {
  @Autowired
  private OrderMapper orderMapper;
  @Autowired
  private OrderMapper1Manage orderMapper1Manage;

  @PostMapping("add")
  public void add(@RequestBody Order order) {
    // 通过mybatis的useGeneratedKeys获取到分布式主键orderId
    orderMapper.insertSelective(order);
    // 对于新表的插入，过滤掉老的表
    if (order.getUserId() % 4 > 1) {
      orderMapper1Manage.insertSelective(order);
    }
  }

  @GetMapping("{orderId}")
  public Order getOrder(@PathVariable Long orderId, @RequestParam Long userId) {
    return orderMapper.selectByUserIdNOrderId(orderId, userId);
  }

  @GetMapping
  public List<Order> getOrder(@RequestParam Long userId) {
    return orderMapper.selectByUserId(userId);
  }

  public static void main(String[] args) {
    System.out.println(543494592646328321L % 32);
  }
}
