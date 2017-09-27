package com.fann.repository;

import com.fann.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by b1109_000 on 2017/7/31.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
        List<ProductInfo> findByProductStatus(Integer productStatus);
}
