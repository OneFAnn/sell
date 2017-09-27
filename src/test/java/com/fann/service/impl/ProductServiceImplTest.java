package com.fann.service.impl;

import com.fann.dataobject.ProductInfo;
import com.fann.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by b1109_000 on 2017/7/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void testFindOne() throws Exception {
        ProductInfo productInfo = productService.findOne("12345");
        Assert.assertEquals("12345",productInfo.getProductId());
    }

    @Test
    public void testFindUpAll() throws Exception {
        List<ProductInfo> list =  productService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void testFindAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> page = productService.findAll(pageRequest);
        System.out.println(page.getTotalElements());
    }

    @Test
    public void testSave() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234567");
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("好de螃蟹");
        productInfo.setProductIcon("xxxxxxxxxx");
        productInfo.setProductName("螃蟹");
        productInfo.setProductPrice(new BigDecimal("200"));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(200);
        productService.save(productInfo);
    }

    @Test
    public void testOffSale() {
        ProductInfo productInfo = productService.offSale("12");
        Assert.assertEquals(ProductStatusEnum.DOWN,productInfo.getProductStatusEnum());
    }

    @Test
    public void testOnSale() {
        ProductInfo productInfo = productService.onSale("12");
        Assert.assertEquals(ProductStatusEnum.UP,productInfo.getProductStatusEnum());
    }

}