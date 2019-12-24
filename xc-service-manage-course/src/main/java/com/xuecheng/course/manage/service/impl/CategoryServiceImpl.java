package com.xuecheng.course.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.course.manage.entity.Category;
import com.xuecheng.course.manage.mapper.CategoryMapper;
import com.xuecheng.course.manage.outVo.CategoryNode;
import com.xuecheng.course.manage.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryNode getCateGoryList() {

        categoryMapper.getCateGoryList();

        return null;
    }
}
