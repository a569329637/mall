package com.gsq.mall.user.enums;

public enum UserStatusEnum {
    NORMAL(0, "normal"),
    BLOCK(1, "block"),
    ;

    private Integer status;
    private String Desc;

    private UserStatusEnum(Integer status, String desc) {
        this.status = status;
        Desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return Desc;
    }
}
