package com.xuecheng.course.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teachplan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    private String pname;

    private String parentid;

    /**
     * 层级，分为1、2、3级
     */
    private String grade;

    /**
     * 课程类型:1视频、2文档
     */
    private String ptype;

    /**
     * 章节及课程时介绍
     */
    private String description;

    /**
     * 时长，单位分钟
     */
    private Double timelength;

    /**
     * 课程id
     */
    private String courseid;

    /**
     * 排序字段
     */
    private String orderby;

    /**
     * 状态：未发布、已发布
     */
    private String status;

    /**
     * 是否试学
     */
    private String trylearn;


}
