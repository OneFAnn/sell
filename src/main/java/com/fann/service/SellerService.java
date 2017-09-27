package com.fann.service;

import com.fann.dataobject.SellerInfo;

/**
 * Created by b1109_000 on 2017/9/15.
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
}
