package com.gsq.mall.order.controller.params;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateOrderParams implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private Long userAddressId;
    private Long goodsId;
    private Integer goodsCount;

}
