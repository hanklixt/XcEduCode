package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lxt
 * @date 2019-10-31-17:07
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {

    /**
     * 根据
     *
     * @param pageName
     * @param pageWebPath
     * @param siteId
     * @return
     */
    CmsPage findByPageNameAndPageWebPathAndSiteId(String pageName, String pageWebPath, String siteId);

}
