package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.CommonCode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HttpResultUtil {

    public HttpResult success(Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(CommonCode.SUCCESS.getCode());
        httpResult.setMessage(CommonCode.SUCCESS.getMessage());
        httpResult.setData(data);
        return httpResult;
    }


    public HttpResult success(Integer  code,String message,Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setData(data);
        httpResult.setMessage(message);
        return httpResult;
    }

    public HttpResult error(CommonCode commonCode){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(commonCode.getCode());
        httpResult.setMessage(commonCode.getMessage());
        return httpResult;
    }

    public HttpResult error(Integer  code,String message){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setMessage(message);
        return httpResult;
    }
}
