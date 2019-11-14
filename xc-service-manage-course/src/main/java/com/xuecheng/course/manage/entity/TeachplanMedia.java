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
public class TeachplanMedia implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程计划id
     */
    @TableId(value = "teachplan_id", type = IdType.INPUT)
    private String teachplanId;

    /**
     * 媒资文件id
     */
    private String mediaId;

    /**
     * 媒资文件的原始名称
     */
    private String mediaFileoriginalname;

    /**
     * 媒资文件访问地址
     */
    private String mediaUrl;

    /**
     * 课程Id
     */
    private String courseid;


}
