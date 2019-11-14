package com.xuecheng.client.service;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.client.dao.CmsPageRepository;
import com.xuecheng.client.dao.CmsSiteRepository;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * @author lxt
 * @date 2019-11-13-15:15
 */
@Service
@Slf4j
public class PageService {


    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private GridFSBucket gridFSBucket;
    @Autowired
    private CmsPageRepository cmsPageRepository;
    @Autowired
    private CmsSiteRepository cmsSiteRepository;

    /**
     * 接受消息，包页面保存到服务器
     *
     * @param pageId
     */
    public void savePageToServerPath(String pageId) {
        final CmsPage cmsPage = this.getCmsPageById(pageId);
        if (ObjectUtil.isNull(cmsPage)) {
            return;
        }
        //站点信息
        final String siteId = cmsPage.getSiteId();
        final CmsSite cmsSite = this.getCmsSiteById(siteId);
        if (ObjectUtil.isNull(cmsSite)) {
            return;
        }
        String pagePath = cmsSite.getSitePhysicalPath() + cmsPage.getPagePhysicalPath() +
                cmsPage.getPageName();
        //html文件id
        final String htmlFileId = cmsPage.getHtmlFileId();
        final InputStream inputStream = getHtmlInputStream(htmlFileId);
        if (ObjectUtil.isNull(inputStream)) {
            log.error("inputStream isNull!!");
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(pagePath));
            IoUtil.copy(inputStream, fileOutputStream);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            IoUtil.close(inputStream);
            IoUtil.close(fileOutputStream);
        }
    }

    /**
     * 获取站点信息
     *
     * @return
     */
    private CmsSite getCmsSiteById(String pageId) {
        final Optional<CmsSite> optional = cmsSiteRepository.findById(pageId);
        if (optional.isPresent()) {
            final CmsSite cmsSite = optional.get();
            return cmsSite;
        }
        return null;
    }

    /**
     * 获取页面对象
     *
     * @param pageId
     * @return
     */
    private CmsPage getCmsPageById(String pageId) {
        final Optional<CmsPage> optional = cmsPageRepository.findById(pageId);
        if (optional.isPresent()) {
            final CmsPage cmsPage = optional.get();
            return cmsPage;
        }
        return null;
    }

    /**
     * 获取文件输入流
     *
     * @param fieldId
     * @return
     */
    private InputStream getHtmlInputStream(String fieldId) {
        final GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fieldId)));
        final GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        final GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        InputStream inputStream = null;
        try {
            inputStream = gridFsResource.getInputStream();
        } catch (IOException e) {
            log.error("getHtmlInputStream is exceptioned:{}", e.getMessage());
        }
        return inputStream;
    }
}
