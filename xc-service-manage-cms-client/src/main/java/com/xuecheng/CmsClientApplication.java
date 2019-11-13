package com.xuecheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author lxt
 * @date 2019-11-13-14:35
 */

@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.cms")//扫描实体类
public class CmsClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsClientApplication.class, args);
    }
}
