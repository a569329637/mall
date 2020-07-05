package com.gsq.mall.order.enums;

public enum OrderStatusEnum {

    UNPAID(0, "Unpaid"),
    PAYMENT_SUCCESSFUL(1, "Payment successful"),
    PAYMENT_FAILED(2, "Payment failed"),
    TO_BE_REFUNDED(3, "To be refunded"),
    REFUNDED(4, "Refunded"),
    ;

    private Integer status;
    private String Desc;

    private OrderStatusEnum(Integer status, String desc) {
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
