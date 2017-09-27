package com.fann.enums;

/**
 * Created by b1109_000 on 2017/7/31.
 */
public enum OrderStatusEnum implements CodeEnum {

    NEW(0,"新订单"),
    FINSHED(1,"完结"),
    CANCEL(2,"已取消");


    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
