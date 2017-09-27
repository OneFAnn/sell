package com.fann.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by b1109_000 on 2017/9/15.
 */
@Component
@ConfigurationProperties(prefix = "projectUrl")
public class ProjectUrl {

    private String wechatMpAuthorize;
    private String wechatOpenAuthorize;
    private String sell;

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getWechatMpAuthorize() {
        return wechatMpAuthorize;
    }

    public void setWechatMpAuthorize(String wechatMpAuthorize) {
        this.wechatMpAuthorize = wechatMpAuthorize;
    }

    public String getWechatOpenAuthorize() {
        return wechatOpenAuthorize;
    }

    public void setWechatOpenAuthorize(String wechatOpenAuthorize) {
        this.wechatOpenAuthorize = wechatOpenAuthorize;
    }
}
