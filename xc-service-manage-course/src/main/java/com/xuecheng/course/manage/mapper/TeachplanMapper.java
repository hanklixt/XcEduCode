package com.xuecheng.course.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.course.manage.entity.Teachplan;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
public interface TeachplanMapper extends BaseMapper<Teachplan> {

    /**
     * 查询树形节点
     *
     * @param courseId
     * @return
     */
    TeachplanNode selectNodeList(@Param("courseId") String courseId);
}
