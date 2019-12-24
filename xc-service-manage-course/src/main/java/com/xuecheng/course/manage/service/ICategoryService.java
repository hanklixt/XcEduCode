package com.xuecheng.course.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.course.manage.entity.Category;
import com.xuecheng.course.manage.outVo.CategoryNode;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
public interface ICategoryService extends IService<Category> {

    CategoryNode getCateGoryList();
}
