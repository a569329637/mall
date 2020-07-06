package com.gsq.mall.goods.core;

import com.gsq.mall.goods.enums.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseData<ResultEnum> handleException(Exception e) {
        e.printStackTrace();
        return new ResponseData<>(ResultEnum.SYSTEM_ERROR);
    }

}
