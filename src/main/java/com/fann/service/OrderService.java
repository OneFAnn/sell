package com.fann.service;

import com.fann.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.Order;

import java.util.List;

/**
 * Created by b1109_000 on 2017/8/1.
 */
public interface OrderService {
    /* 创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    /* 查询单个订单*/
    OrderDTO findOne(String orderId);

    /*查询订单列表*/
    Page<OrderDTO> findList(String openid, Pageable pageable);

    /* 取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /* 完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /* 支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

    /* 查询订单列表*/
    Page<OrderDTO> findList(Pageable pageable);
}
