package com.fann.handler;

import com.fann.config.ProjectUrl;
import com.fann.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by b1109_000 on 2017/9/16.
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrl projectUrl;
    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeExcetion() {
        return new ModelAndView("redirect:"
                .concat(projectUrl.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrUserInfo")
                .concat("?returnUrl=")
                .concat(projectUrl.getSell())
                .concat("/sell/seller/login"));
    }
}
