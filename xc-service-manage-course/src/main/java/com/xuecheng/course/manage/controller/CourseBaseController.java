package com.xuecheng.course.manage.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.course.manage.service.ICourseBaseService;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.exception.HttpResult;
import com.xuecheng.framework.model.response.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/coursebase")
public class CourseBaseController {

    @Autowired
    private ICourseBaseService courseBaseService;

    @PostMapping("/findCourseList/{page}/{size}")
    public Mono<HttpResult> findCourseList(@PathVariable Long page, @PathVariable Long size, @RequestBody CourseListRequest courseListRequest) {
        final Page<CourseInfo> courseList = courseBaseService.findCourseList(page, size, courseListRequest);
        return Mono.create(x -> {
            x.success(new HttpResult(CommonCode.SUCCESS, courseList));
        });
    }
}
