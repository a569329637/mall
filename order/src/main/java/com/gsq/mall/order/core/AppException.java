package com.gsq.mall.order.core;

import com.gsq.mall.order.enums.ResultEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {

    private ResultEnum resultEnum;

    public AppException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
