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
public class CourseMarket implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 收费规则，对应数据字典
     */
    private String charge;

    /**
     * 有效性，对应数据字典
     */
    private String valid;

    /**
     * 过期时间
     */
    private LocalDateTime expires;

    /**
     * 咨询qq
     */
    private String qq;

    /**
     * 价格
     */
    private Float price;

    /**
     * 原价
     */
    private Float priceOld;

    /**
     * 课程有效期-开始时间
     */
    private LocalDateTime startTime;

    /**
     * 课程有效期-结束时间
     */
    private LocalDateTime endTime;


}
