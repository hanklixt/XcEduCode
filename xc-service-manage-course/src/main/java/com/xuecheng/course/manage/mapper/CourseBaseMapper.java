package com.xuecheng.course.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.course.manage.entity.CourseBase;
import com.xuecheng.framework.domain.course.ext.CourseInfo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
public interface CourseBaseMapper extends BaseMapper<CourseBase> {

    /**
     * 查询课程信息
     *
     * @param page
     * @return
     */
    List<CourseInfo> findCourseList(Page page);
}
