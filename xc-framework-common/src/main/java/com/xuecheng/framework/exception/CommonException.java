package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.CommonCode;
import lombok.Data;

@Data
public class CommonException extends RuntimeException {

    private Integer code;
    private String message;

    public CommonException(Integer code,String message){
        super(message);
        this.code=code;
        this.message=message;
    }

    public CommonException(String message){
        super(message);
        this.code=100;
        this.message=message;
    }

    public CommonException(CommonCode commonCode){
        super(commonCode.getMessage());
        this.code=commonCode.getCode();
        this.message=commonCode.getMessage();
    }


}
