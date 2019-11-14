package com.xuecheng.course.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lxt
 * @date 2019-11-14-16:07
 */
@SpringBootApplication
@MapperScan("com.xuecheng.course.manage.mapper")
public class CourseManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseManageApplication.class, args);
    }
}
