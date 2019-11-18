package com.xuecheng.course.manage.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.course.manage.entity.CourseBase;
import com.xuecheng.course.manage.entity.Teachplan;
import com.xuecheng.course.manage.mapper.TeachplanMapper;
import com.xuecheng.course.manage.service.ICourseBaseService;
import com.xuecheng.course.manage.service.ITeachplanService;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.exception.CommonException;
import com.xuecheng.framework.model.response.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

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
    @Autowired
    private ICourseBaseService baseService;

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
    @Transactional(rollbackFor = Exception.class)
    public void addTeachPlan(Teachplan teachplan) {
        if (ObjectUtil.isNull(teachplan) || StrUtil.isBlank(teachplan.getCourseid()) || StrUtil.isBlank(teachplan.getPname())) {
            throw new CommonException(CommonCode.BAD_REQUEST);
        }
        final String courseid = teachplan.getCourseid();
        final String parentid = teachplan.getParentid();
        if (StrUtil.isBlank(parentid)) {
            final String teachPlanRoot = getTeachPlanRoot(courseid);
            if (StrUtil.isBlank(teachPlanRoot)) {
                throw new CommonException(CommonCode.BAD_REQUEST);
            }
            teachplan.setParentid(teachPlanRoot);
            final Teachplan plan = getById(teachPlanRoot);
            final String grade = plan.getGrade();
            if ("1".equals(grade)) {
                teachplan.setGrade("2");
            } else {
                teachplan.setGrade("3");
            }
        }
        final String id = UUID.randomUUID().toString().replaceAll("-", "");
        teachplan.setId(id);
        save(teachplan);
    }


    /**
     * 获取课程计划根节点
     *
     * @param courseId
     * @return
     */
    private String getTeachPlanRoot(String courseId) {
        //查询基本课程
        final CourseBase courseBase = baseService.getById(courseId);
        if (ObjectUtil.isNull(courseBase)) {
            return null;
        }
        final List<Teachplan> list = list(new LambdaQueryWrapper<Teachplan>().eq(Teachplan::getCourseid, courseId).eq(Teachplan::getParentid, 0));
        if (CollectionUtils.isEmpty(list)) {
            //如果根节点不存在，创建一个根节点
            Teachplan teachplan = new Teachplan();
            teachplan.setParentid("0");
            teachplan.setGrade("1");
            teachplan.setCourseid(courseId);
            teachplan.setPname(courseBase.getName());
            teachplan.setStatus("0");
            final String id = UUID.randomUUID().toString().replaceAll("-", "");
            teachplan.setId(id);
            save(teachplan);
            return id;
        }
        return list.get(0).getId();
    }
}
