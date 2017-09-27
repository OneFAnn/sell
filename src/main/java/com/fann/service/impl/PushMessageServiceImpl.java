package com.fann.service.impl;

import com.fann.config.WechatMpAccountConfig;
import com.fann.dto.OrderDTO;
import com.fann.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by b1109_000 on 2017/9/16.
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WechatMpAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setToUser(orderDTO.getBuyerOpenid());
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "亲，记得收货"),
                new WxMpTemplateData("keyword1", "微信点餐"),
                new WxMpTemplateData("keyword2", "12121212121"),
                new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4", orderDTO.getPayStatusEnum().getMsg()),
                new WxMpTemplateData("keyword5", "￥"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","欢迎再次光临！")
                );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败,{}",e);

        }
    }
}
