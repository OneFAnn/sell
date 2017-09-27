package com.fann.repository;

import com.fann.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by b1109_000 on 2017/7/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.print(productCategory.toString());
    }
    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        productCategoryRepository.save(productCategory);
    }
    @Test
    public void updateTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        productCategory.setCategoryName("2222最爱");
        productCategoryRepository.save(productCategory);
    }
    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(3,2);
        List list2 = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,list2.size());
        System.out.println(list2.size());
    }

}