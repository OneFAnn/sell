package com.fann.service;

import com.fann.dto.OrderDTO;

/**
 * Created by b1109_000 on 2017/9/16.
 */
public interface PushMessageService {
    void orderStatus(OrderDTO orderDTO);
}
