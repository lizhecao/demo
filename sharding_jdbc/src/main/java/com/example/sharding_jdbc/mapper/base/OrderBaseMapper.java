package com.example.sharding_jdbc.mapper.base;

import com.example.sharding_jdbc.model.OrderEntity;

import java.util.List;
/**
*  @author author
*/
public interface OrderBaseMapper {

    int insertOrderEntity(OrderEntity object);

    int updateOrderEntity(OrderEntity object);

    int update(OrderEntity.UpdateBuilder object);

    List<OrderEntity> queryOrderEntity(OrderEntity object);

    OrderEntity queryOrderEntityLimit1(OrderEntity object);

}