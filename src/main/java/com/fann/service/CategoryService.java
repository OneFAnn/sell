package com.fann.service;

import com.fann.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by b1109_000 on 2017/7/31.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
