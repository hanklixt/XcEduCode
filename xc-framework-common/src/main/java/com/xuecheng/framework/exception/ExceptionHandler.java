package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.CommonCode;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public HttpResult exceptionHandle(Exception e) {
        if (e instanceof CommonException) {
            CommonException exception = (CommonException) e;
            HttpResultUtil.error(exception.getCode(), exception.getMessage());
        }
        //todo 补充细分异常

        return new HttpResult(CommonCode.FAIL.getCode(), "系统错误");

    }

}
