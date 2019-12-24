package com.xuecheng.course.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.course.manage.entity.Category;
import com.xuecheng.course.manage.outVo.CategoryNode;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
public interface CategoryMapper extends BaseMapper<Category> {

    CategoryNode getCateGoryList();
}
