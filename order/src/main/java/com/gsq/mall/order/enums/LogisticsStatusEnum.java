package com.gsq.mall.order.enums;

public enum LogisticsStatusEnum {

    INIT(0, "init"),
    TO_BE_DELIVERED(1, "To be delivered"),
    TO_BE_RECEIVED(2, "o be received"),
    RECEIVED(3, "received"),
    ;

    private Integer status;
    private String Desc;

    private LogisticsStatusEnum(Integer status, String desc) {
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
