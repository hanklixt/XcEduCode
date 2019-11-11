package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manage_cms.dao.CmsConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author lxt
 * @date 2019-11-11-14:21
 */
@Service
public class CmsConfigService {

    @Autowired
    private CmsConfigRepository configRepository;

    public CmsConfig getModelById(String id) {
        final Optional<CmsConfig> optional = configRepository.findById(id);
        if (optional.isPresent()) {
            final CmsConfig cmsConfig = optional.get();
            return cmsConfig;
        }
        return null;
    }
}
