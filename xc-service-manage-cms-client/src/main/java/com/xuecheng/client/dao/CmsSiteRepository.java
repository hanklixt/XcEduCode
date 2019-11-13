package com.xuecheng.client.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lxt
 * @date 2019-11-13-15:17
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite, String> {

}
