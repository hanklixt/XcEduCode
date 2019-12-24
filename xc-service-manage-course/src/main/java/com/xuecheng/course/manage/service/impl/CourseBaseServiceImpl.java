package com.xuecheng.course.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.course.manage.entity.CourseBase;
import com.xuecheng.course.manage.mapper.CourseBaseMapper;
import com.xuecheng.course.manage.service.ICourseBaseService;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
@Service
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseMapper, CourseBase> implements ICourseBaseService {

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    /**
     * 查询课程列表
     *
     * @param pageNo
     * @param size
     * @param courseListRequest
     * @return
     */
    @Override
    public Page<CourseInfo> findCourseList(Long pageNo, Long size, CourseListRequest courseListRequest) {
        Page<CourseInfo> page = new Page<CourseInfo>().setSize(size).setCurrent(pageNo);
        return page.setRecords(courseBaseMapper.findCourseList(page));
    }
}
