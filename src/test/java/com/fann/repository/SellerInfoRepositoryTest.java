package com.fann.repository;

import com.fann.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by b1109_000 on 2017/9/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void testSave() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("123");
        sellerInfo.setId("1");
        sellerInfo.setUsername("小命");
        sellerInfo.setPassword("1111");
        SellerInfo result = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByOpenid() throws Exception {
        SellerInfo sellerInfo1 = sellerInfoRepository.findByOpenid("123");
        Assert.assertNotNull(sellerInfo1);
    }
}