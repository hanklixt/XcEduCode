package com.xuecheng.course.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.course.manage.entity.Teachplan;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
public interface ITeachplanService extends IService<Teachplan> {

    /**
     * 查询树形节点
     *
     * @param courseId
     * @return
     */
    TeachplanNode selectNodeList(String courseId);

    /***
     * 查询课程计划
     * @param courseId
     * @param parentId
     * @return
     */
    List<Teachplan> findByCourseIdAndParentId(String courseId, String parentId);

    void addTeachPlan(Teachplan teachplan);
}
