package com.fann.repository;

import com.fann.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by b1109_000 on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testFindByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("123");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("123");
        orderDetail.setDetailId("111");
        orderDetail.setProductIcon("http://xxxxx");
        orderDetail.setProductId("666");
        orderDetail.setProductName("66");
        orderDetail.setProductPrice(new BigDecimal("2.5"));
        orderDetail.setProductQuantity(100);
        OrderDetail od = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(od);

    }
}