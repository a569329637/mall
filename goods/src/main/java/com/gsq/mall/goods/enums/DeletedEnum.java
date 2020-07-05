package com.gsq.mall.goods.enums;

public enum DeletedEnum {
    NO(0, "no"),
    YES(1, "yes"),
    ;

    private Integer status;
    private String Desc;

    private DeletedEnum(Integer status, String desc) {
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
