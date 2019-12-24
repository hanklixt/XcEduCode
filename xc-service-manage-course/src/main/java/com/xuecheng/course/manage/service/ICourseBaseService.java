package com.xuecheng.course.manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.course.manage.entity.CourseBase;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
public interface ICourseBaseService extends IService<CourseBase> {

    /**
     * 查询课程列表
     *
     * @param page
     * @param size
     * @param courseListRequest
     * @return
     */
    Page<CourseInfo> findCourseList(Long page, Long size, CourseListRequest courseListRequest);
}
