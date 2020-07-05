package com.gsq.mall.order.enums;

import lombok.Getter;

public enum ResultEnum {

    SUCCESS("200", "success"),
    SYSTEM_ERROR("500", "system error"),

    USER_NOT_FOUND("1000", "user not found"),
    USER_ADDRESS_NOT_FOUND("1001", "user address not found"),
    GOODS_NOT_FOUND("1002", "goods not found"),
    GOODS_COUNT_NOT_ENOUGH("1003", "goods count not enough"),
    ;

    @Getter
    private String code;

    @Getter
    private String msg;

    private ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
