package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;

/**
 * @author lxt
 * @date 2019-10-31-15:11
 */
public interface CmsPageControllerApi {
    /**
     * 通用分页
     *
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
