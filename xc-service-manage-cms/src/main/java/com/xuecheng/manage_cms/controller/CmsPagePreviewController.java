package com.xuecheng.manage_cms.controller;

import com.xuecheng.manage_cms.service.CmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lxt
 * @date 2019-11-12-11:45
 */
@Controller
@RequestMapping("/cms/preview")
public class CmsPagePreviewController {

    @Autowired
    private CmsService cmsService;

    /**
     * 预览页面
     *
     * @param id
     * @param response
     */
    @GetMapping("/{id}")
    public void preview(@PathVariable String id, HttpServletResponse response) {
        final String html = cmsService.getHtmlByPageId(id);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(html.getBytes("utf-8"));
        } catch (IOException e) {

        }
    }
}

