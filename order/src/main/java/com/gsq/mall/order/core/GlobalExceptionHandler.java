package com.gsq.mall.order.core;

import com.gsq.mall.order.enums.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseData<ResultEnum> handleException(Exception e) {
        e.printStackTrace();
        return new ResponseData<>(ResultEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(AppException.class)
    public ResponseData<ResultEnum> handleAppException(HttpServletRequest request,
                                                       final Exception e,
                                                       HttpServletResponse response) {
        e.printStackTrace();
        ResultEnum resultEnum = ((AppException) e).getResultEnum();
        return new ResponseData<>(resultEnum);
    }
}
