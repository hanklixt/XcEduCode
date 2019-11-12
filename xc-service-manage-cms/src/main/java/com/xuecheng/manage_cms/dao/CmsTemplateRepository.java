package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lxt
 * @date 2019-11-12-10:27
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {

}
