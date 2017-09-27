package com.fann.repository;

import com.fann.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by b1109_000 on 2017/7/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void testFindByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0,1);
        Page request = orderMasterRepository.findByBuyerOpenid("110110",pageRequest);
        System.out.println(request.getTotalElements());
    }
    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("zg");
        orderMaster.setBuyerName("士兵");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setBuyerPhone("123456789");
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        orderMaster.setOrderId("123");
        OrderMaster om = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(om);
    }
}