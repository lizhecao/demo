package com.example.sharding_jdbc.controller;

import com.example.sharding_jdbc.mapper.OrderMapper;
import com.example.sharding_jdbc.model.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizhecao 2020/12/9
 * @version 1.0
 */
@RestController
@RequestMapping("order")
public class OrderController {
  @Autowired
  private OrderMapper orderMapper;

  @GetMapping("add")
  public void add(@RequestBody OrderEntity orderEntity) {
    orderMapper.insertOrderEntity(orderEntity);
  }
}
