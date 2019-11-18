package com.xuecheng.course.manage.controller;


import com.xuecheng.course.manage.entity.Teachplan;
import com.xuecheng.course.manage.service.ITeachplanService;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
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
@RequestMapping("/course/teachplan")
public class TeachplanController {

    @Autowired
    private ITeachplanService teachplanService;

    @GetMapping("/list/{courseId}")
    public Mono<HttpResult> list(@PathVariable("courseId") String courseId) {
        final TeachplanNode teachplanNode = teachplanService.selectNodeList(courseId);
        return Mono.create(x -> {
            x.success(new HttpResult(CommonCode.SUCCESS, teachplanNode));
        });
    }

    @PostMapping("/teachPlan/add")
    public Mono<HttpResult> addTeachPlan(@RequestBody Teachplan teachplan) {
        teachplanService.addTeachPlan(teachplan);
        return Mono.create(x -> {
            x.success(new HttpResult(CommonCode.SUCCESS));
        });
    }
}
