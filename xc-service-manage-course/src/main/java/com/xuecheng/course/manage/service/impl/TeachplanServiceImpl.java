package com.xuecheng.course.manage.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.course.manage.entity.Teachplan;
import com.xuecheng.course.manage.mapper.TeachplanMapper;
import com.xuecheng.course.manage.service.ITeachplanService;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
@Service
public class TeachplanServiceImpl extends ServiceImpl<TeachplanMapper, Teachplan> implements ITeachplanService {

    @Autowired
    private TeachplanMapper teachplanMapper;

    /**
     * 查询树形节点
     *
     * @param courseId
     * @return
     */
    @Override
    public TeachplanNode selectNodeList(String courseId) {
        teachplanMapper.selectNodeList(courseId);
        return teachplanMapper.selectNodeList(courseId);
    }

    /***
     * 查询课程计划
     * @param courseId
     * @param parentId
     * @return
     */
    @Override
    public List<Teachplan> findByCourseIdAndParentId(String courseId, String parentId) {
        return null;
    }

    /**
     * 添加课程计划
     *
     * @param teachplan
     */
    @Override
    public void addTeachPlan(Teachplan teachplan) {
        if (ObjectUtil.isNull(teachplan) || StrUtil.isBlank(teachplan.getCourseid()) || StrUtil.isBlank(teachplan.getPname())) {

        }

    }
}
