package com.fann.service.impl;

import com.fann.dataobject.OrderDetail;
import com.fann.dto.OrderDTO;
import com.fann.enums.OrderStatusEnum;
import com.fann.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by b1109_000 on 2017/8/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String OPENID = "110110";
    private  final String ORDERID = "1501645022991104587";
    @Test
    public void testCreate() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("zg");
        orderDTO.setBuyerName("小米");
        orderDTO.setBuyerPhone("111111111");
        orderDTO.setBuyerOpenid(OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("12");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("123");
        orderDetail2.setProductQuantity(10);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);

        orderService.create(orderDTO);
    }

    @Test
    public void testFindOne() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        Assert.assertEquals(ORDERID,orderDTO.getOrderId());
    }

    @Test
    public void testFindList() throws Exception {
        Page<OrderDTO> orderDTOPage = orderService.findList(OPENID, new PageRequest(0, 10));
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void testCancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1501645258275468391");
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void testFinish() throws Exception {
        OrderDTO orderDTO = orderService.findOne("123");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINSHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void testPaid() throws Exception {
        OrderDTO orderDTO = orderService.findOne("123");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void testPage() {
        Pageable pageable = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageable);
        Assert.assertTrue("查询订单列表", orderDTOPage.getTotalElements() > 0);
    }
}