package com.xuecheng.framework.domain.course;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/7.
 */
@Data
@ToString
public class Teachplan implements Serializable {
    private static final long serialVersionUID = -916357110051689485L;
    private String id;
    private String pname;
    private String parentid;
    private String grade;
    private String ptype;
    private String description;
    private String courseid;
    private String status;
    private Integer orderby;
    private Double timelength;
    private String trylearn;

}
