package com.xuecheng.course.manage.controller;


import com.xuecheng.course.manage.outVo.CategoryNode;
import com.xuecheng.course.manage.service.ICategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lxt
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private ICategoryService categoryService;

    @PostMapping
    public CategoryNode getCategoryNodeList() {

        categoryService.getCateGoryList();
        return null;

    }
}
