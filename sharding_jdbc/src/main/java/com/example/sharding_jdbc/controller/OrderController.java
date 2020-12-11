package com.example.sharding_jdbc.controller;

import com.example.sharding_jdbc.entity.Order;
import com.example.sharding_jdbc.mapper.OrderMapper;
import com.example.sharding_jdbc.mapper.OrderMapper1;
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
  private OrderMapper1 orderMapper1;

  @PostMapping("add")
  public void add(@RequestBody Order order) {
    orderMapper.insertSelective(order);
    orderMapper1.insertSelective(order);
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
