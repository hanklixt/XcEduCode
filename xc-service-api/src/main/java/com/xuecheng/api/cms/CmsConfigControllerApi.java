package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsConfig;

/**
 * @author lxt
 * @date 2019-11-11-14:09
 */
public interface CmsConfigControllerApi {
    /**
     * 获取模型对象
     *
     * @param id
     * @return
     */
    CmsConfig getModelById(String id);
}
