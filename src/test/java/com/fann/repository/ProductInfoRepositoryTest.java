package com.fann.repository;

import com.fann.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by b1109_000 on 2017/7/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
        @Autowired
        private ProductInfoRepository productInfoRepository;

        @Test
        public void saveTest(){
            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductId("12345");
            productInfo.setCategoryType(4);
            productInfo.setProductDescription("好的吃皮蛋粥");
            productInfo.setProductIcon("xxxxxxxxxx");
            productInfo.setProductName("皮蛋粥");
            productInfo.setProductPrice(new BigDecimal("2.5"));
            productInfo.setProductStatus(0);
            productInfo.setProductStock(100);
            productInfoRepository.save(productInfo);
        }

    @Test
    public void findByProductStatus(){
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,list.size());
    }
}