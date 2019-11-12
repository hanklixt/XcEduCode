package com.xuecheng.manage_cms.service;

import cn.hutool.core.util.ObjectUtil;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.exception.CommonException;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lxt
 * @date 2019-10-31-17:10
 */
@Slf4j
@Service
public class CmsService implements CmsPageControllerApi {
    @Autowired
    private CmsPageRepository cmsRepository;
    @Autowired
    private CmsConfigService cmsConfigService;
    @Autowired
    private CmsTemplateRepository templateRepository;
    @Autowired
    private GridFSBucket gridFSBucket;
    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 通用分页
     *
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @Override
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //条件值
        CmsPage cmsPage = new CmsPage();
        //站点ID
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        } //页面别名
        if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        } //创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        //页码
        //分页对象
        Pageable pageable = new PageRequest(page - 1, size);
        //分页查询
        Page<CmsPage> all = cmsRepository.findAll(example, pageable);
        QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<CmsPage>();
        cmsPageQueryResult.setList(all.getContent());
        cmsPageQueryResult.setTotal(all.getTotalElements());
//返回结果
        return new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
    }

    //添加页面
    public CmsPageResult add(CmsPage cmsPage) {
        //校验页面是否存在，根据页面名称、站点Id、页面webpath查询
        CmsPage cms = cmsRepository.findByPageNameAndPageWebPathAndSiteId(cmsPage.getPageName(), cmsPage.getPageWebPath(), cmsPage.getSiteId());
        if (Objects.isNull(cms)) {
            cmsPage.setPageId(null);
            //添加页面主键由spring data 自动生成
            cmsRepository.save(cmsPage);
            //返回结果
            CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS, cmsPage);
            return cmsPageResult;
        }
        return new CmsPageResult(CommonCode.FAIL, null);
    }

    public CmsPage findById(String id) {
        final Optional<CmsPage> optional = cmsRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    //修改页面
    public CmsPageResult update(String id, CmsPage cmsPage) {
        final CmsPage cms = findById(id);
        if (ObjectUtil.isNotNull(cms)) {
            BeanUtils.copyProperties(cmsPage, cms);
            cms.setPageId(id);
            final CmsPage save = cmsRepository.save(cms);
            if (ObjectUtil.isNotNull(save)) {
                //返回成功
                CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS, save);
                return cmsPageResult;
            }
        }
        return new CmsPageResult(CommonCode.FAIL, null);
    }

    /**
     * 删除页面
     *
     * @param id
     * @return
     */
    public ResponseResult delete(String id) {
        cmsRepository.deleteById(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }


    public String getHtmlByPageId(String pageId) {
        //获取渲染模板需要的数据
        final Map model = this.getModelByPageId(pageId);
        if (CollectionUtils.isEmpty(model)) {
            throw new CommonException(CommonCode.NO_DATAINFO);
        }
        //获取模板
        final String template = getTemplateByPageId(pageId);
        final String html = generateHtml(model, template);
        if (StringUtils.isBlank(html)) {
            throw new CommonException(CommonCode.FAIL_GENERATE);
        }
        return html;
    }

    /**
     * 根据数据和模板生成页面
     *
     * @param model
     * @param template
     * @return
     */
    private String generateHtml(Map model, String template) {
        try {
            //生成模板类
            final Configuration configuration = new Configuration(Configuration.getVersion());
            //模板加载器
            final StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
            stringTemplateLoader.putTemplate("template", template);
            //配置模板加载器
            configuration.setTemplateLoader(stringTemplateLoader);
            final Template template1 = configuration.getTemplate("template");
            try {
                final String html = FreeMarkerTemplateUtils.processTemplateIntoString(template1, model);
                return html;
            } catch (TemplateException e) {
                log.error("生成模板失败");
                return null;
            }
        } catch (IOException e) {

        }
        return null;
    }

    /**
     * 根据页面id查询获取模型数据
     *
     * @param pageId
     * @return
     */
    private Map getModelByPageId(String pageId) {
        final CmsPage cmsPage = findById(pageId);
        if (ObjectUtil.isNull(cmsPage)) {
            throw new CommonException(CommonCode.NO_PAGE);
        }
        if (StringUtils.isBlank(cmsPage.getDataUrl())) {
            throw new CommonException(CommonCode.NO_DATA);
        }
        final ResponseEntity<Map> responseEntity = restTemplate.getForEntity(cmsPage.getDataUrl(), Map.class);
        final Map body = responseEntity.getBody();
        return body;
    }

    /**
     * 根据pageId获取模板内容
     *
     * @param pageId
     * @return
     */
    private String getTemplateByPageId(String pageId) {
        final CmsPage cmsPage = findById(pageId);
        if (ObjectUtil.isNull(cmsPage)) {
            throw new CommonException(CommonCode.NO_PAGE);
        }
        if (StringUtils.isBlank(cmsPage.getTemplateId())) {
            throw new CommonException(CommonCode.NO_TEMPLATE);
        }
        final Optional<CmsTemplate> optional = templateRepository.findById(cmsPage.getTemplateId());
        if (optional.isPresent()) {
            final CmsTemplate cmsTemplate = optional.get();
            if (ObjectUtil.isNull(cmsTemplate)) {
                throw new CommonException(CommonCode.NO_TEMPLATE);
            }
            if (StringUtils.isBlank(cmsTemplate.getTemplateFileId())) {
                throw new CommonException(CommonCode.NO_TEMPLATE);
            }
            final GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(cmsTemplate.getTemplateFileId())));
            if (ObjectUtil.isNull(gridFSFile)) {
                throw new CommonException(CommonCode.NO_TEMPLATE);
            }
            //下载文件
            final GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());

            final GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
            try {
                final InputStream inputStream = gridFsResource.getInputStream();
                //读取内容
                return IOUtils.toString(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


}
