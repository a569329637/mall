package com.gsq.mall.user.enums;

import lombok.Getter;

public enum ResultEnum {

    SUCCESS("200", "success"),
    SYSTEM_ERROR("500", "system error"),
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

