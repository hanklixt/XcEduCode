package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.CmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lxt
 * @date 2019-11-01-9:12
 */
@RequestMapping("/cms")
@RestController
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    private CmsService cmsService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")
            int size, QueryPageRequest queryPageRequest) {
        return cmsService.findList(page, size, queryPageRequest);
    }

    @PostMapping("/add")
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {
        return cmsService.add(cmsPage);
    }

    @PutMapping("/edit/{id}")
    public CmsPageResult edit(@PathVariable("id") String id, @RequestBody CmsPage cmsPage) {
        return cmsService.update(id, cmsPage);
    }

    @GetMapping("/get/{id}")
    public CmsPage findById(@PathVariable("id") String id) {
        return cmsService.findById(id);
    }

    @DeleteMapping("/del/{id}")
    public ResponseResult delete(@PathVariable String id) {
        return cmsService.delete(id);
    }

    @PostMapping("/post/{pageId}")
    public ResponseResult postPage(@PathVariable("pageId") String pageId) {
        final CmsPage cmsPage = cmsService.postPage(pageId);
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
