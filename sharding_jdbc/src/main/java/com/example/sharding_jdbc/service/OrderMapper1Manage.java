package com.example.sharding_jdbc.service;

import com.example.sharding_jdbc.entity.Order;
import com.example.sharding_jdbc.mapper.OrderMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lizhecao 2020/12/13
 * @version 1.0
 */
@Service
public class OrderMapper1Manage {
  @Autowired
  private OrderMapper1 orderMapper1;

  public int insertSelective(Order record) {
    if (dataBelongToNewDB(record)) {
      // 插入的时候不要插入id
      record.setId(null);
      int i = orderMapper1.insertSelective(record);
      System.out.println("插入订单" + record.getOrderId() + "完成");
      return i;
    }
    System.out.println("订单" + record.getOrderId() + "不属于新库，不需要插入");
    return 0;
  }

  boolean dataBelongToNewDB(Order record) {
    if (record.getUserId() % 4 > 1) {
      return true;
    }
    return false;
  }
}
