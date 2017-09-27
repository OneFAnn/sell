package com.fann.controller;

import com.fann.dataobject.ProductCategory;
import com.fann.dataobject.ProductInfo;
import com.fann.service.CategoryService;
import com.fann.service.ProductService;
import com.fann.utils.ResultVoUtil;
import com.fann.vo.ProductInfoVo;
import com.fann.vo.ProductVo;
import com.fann.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by b1109_000 on 2017/7/31.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){

        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目（一次性查询）
        List<Integer> productTypeList = new ArrayList<Integer>();
        for (ProductInfo productInfo : productInfoList) {
            productTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(productTypeList);

        //3.数据的拼装
        List<ProductVo> productVoList = new ArrayList<ProductVo>();
        ProductVo productVo = null;
            //3.1类目数据的拼装
        for (ProductCategory productCategory : productCategoryList) {
            productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            //3.2商品数据的拼装
            List<ProductInfoVo> productInfoVoList = new ArrayList<ProductInfoVo>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    productInfoVo.setProductPrice(productInfo.getProductPrice());
                    productInfoVo.setProductDescription(productInfo.getProductDescription());
                    productInfoVo.setProductIcon(productInfo.getProductIcon());
                    productInfoVo.setProductId(productInfo.getProductId());
                    productInfoVo.setProductName(productInfo.getProductName());
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        return ResultVoUtil.success(productVoList);
    }
}
