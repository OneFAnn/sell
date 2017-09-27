package com.fann.service.impl;

import com.fann.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by b1109_000 on 2017/9/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void testOrderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1501903997631790554");
        pushMessageService.orderStatus(orderDTO);
    }
}