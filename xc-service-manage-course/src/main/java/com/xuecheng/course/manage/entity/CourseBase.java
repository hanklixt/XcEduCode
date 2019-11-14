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
public class CourseBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 适用人群
     */
    private String users;

    /**
     * 课程大分类
     */
    private String mt;

    /**
     * 课程等级
     */
    private String grade;

    /**
     * 学习模式
     */
    private String studymodel;

    /**
     * 授课模式
     */
    private String teachmode;

    /**
     * 课程介绍
     */
    private String description;

    /**
     * 课程小分类
     */
    private String st;

    /**
     * 课程状态
     */
    private String status;

    /**
     * 教育机构
     */
    private String companyId;

    /**
     * 创建用户
     */
    private String userId;


}
