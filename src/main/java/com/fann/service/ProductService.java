package com.fann.service;

import com.fann.dataobject.ProductInfo;
import com.fann.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by b1109_000 on 2017/7/31.
 */

public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    void decreaseStock(List<CartDTO> cartDTOList);

    void increaseStock(List<CartDTO> cartDTOList);

    public ProductInfo onSale(String productId);

    public ProductInfo offSale(String productId);

}
