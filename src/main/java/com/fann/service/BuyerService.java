package com.fann.service;

import com.fann.dto.OrderDTO;

/**
 * Created by b1109_000 on 2017/8/5.
 */
public interface BuyerService {
    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancel(String openid,String orderId);
}
