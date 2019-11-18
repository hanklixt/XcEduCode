package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.CommonCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lxt
 */
@Data
@NoArgsConstructor
public class HttpResult {
    private Integer code;
    private String message;
    private Object data;

    public HttpResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpResult(CommonCode commonCode, Object data) {
        this.code = commonCode.getCode();
        this.message = commonCode.getMessage();
        this.data = data;
    }

}
