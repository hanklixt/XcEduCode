package com.xuecheng.framework.exception;

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

}
