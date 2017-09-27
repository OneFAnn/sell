package com.fann.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by b1109_000 on 2017/9/6.
 */
@Component
public class WechatMpConfig {

    @Autowired
    private WechatMpAccountConfig wechatMpAccountConfig;

    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage config  = new WxMpInMemoryConfigStorage();
        config.setAppId(wechatMpAccountConfig.getMpAppId()); // 设置微信公众号的appid
        config.setSecret(wechatMpAccountConfig.getMpAppSecret()); // 设置微信公众号的app corpSecret
  //      config.setToken("..."); // 设置微信公众号的token
//        config.setAesKey("..."); // 设置微信公众号的EncodingAESKey
        return config;
    }

    }

