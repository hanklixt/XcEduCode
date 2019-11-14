package com.xuecheng.course.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
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
public class CourseOff implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
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
     * 大分类
     */
    private String mt;

    /**
     * 小分类
     */
    private String st;

    /**
     * 课程等级
     */
    private String grade;

    /**
     * 学习模式
     */
    private String studymodel;

    /**
     * 课程介绍
     */
    private String description;

    /**
     * 时间戳
     */
    private LocalDateTime timestamp;

    /**
     * 收费规则，对应数据字典
     */
    private String charge;

    /**
     * 有效性，对应数据字典
     */
    private String valid;

    /**
     * 咨询qq
     */
    private String qq;

    /**
     * 价格
     */
    private Float price;

    /**
     * 原价格
     */
    private Float priceOld;

    /**
     * 过期时间
     */
    private LocalDateTime expires;

    /**
     * 课程图片
     */
    private String pic;

    /**
     * 课程计划
     */
    private String teachplan;


}
