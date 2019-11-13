package com.xuecheng.client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lxt
 * @date 2019-11-13-15:13
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {

}
