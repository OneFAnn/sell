package com.fann.enums;

/**
 * Created by b1109_000 on 2017/7/31.
 */
public enum PayStatusEnum implements CodeEnum{

    WAIT(0,"未支付"),
    SUCCESS(1,"已支付"),
    ;


    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
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
