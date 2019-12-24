package com.xuecheng.course.manage.outVo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author lxt
 * @date 2019-11-18-17:50
 */
@Data
@ToString
public class CategoryNode {
    private String label;
    private String value;
    private List<CategoryNode> children;
}
