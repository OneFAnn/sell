package com.fann.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by b1109_000 on 2017/9/8.
 */
@Component
public class WechatPayConfig {
    @Autowired
    private WechatMpAccountConfig wechatMpAccountConfig;

    @Bean
    public BestPayServiceImpl bestPayService() {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config());
        return bestPayService;
    }

    @Bean
    public WxPayH5Config wxPayH5Config() {
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(wechatMpAccountConfig.getMpAppId());
        wxPayH5Config.setAppSecret(wechatMpAccountConfig.getMpAppSecret());
        wxPayH5Config.setMchId(wechatMpAccountConfig.getMchId());
        wxPayH5Config.setMchKey(wechatMpAccountConfig.getMchKey());
        wxPayH5Config.setKeyPath(wechatMpAccountConfig.getKeyPath());
        wxPayH5Config.setNotifyUrl(wechatMpAccountConfig.getNotifyUrl());
        return wxPayH5Config;
    }

}
