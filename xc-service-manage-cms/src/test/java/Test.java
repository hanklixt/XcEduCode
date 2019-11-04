import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.ManageCmsApplication;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lxt
 * @date 2019-11-04-16:26
 */
@SpringBootTest(classes = ManageCmsApplication.class)
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private CmsPageRepository cmsPageRepository;

    @org.junit.Test
    public void test() {

        Pageable pageable = PageRequest.of(0, 10);
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        cmsPage.setPageAliase("预览");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //包含匹配
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<CmsPage> cmsPageExample = Example.of(cmsPage, exampleMatcher);
        final Page<CmsPage> all = cmsPageRepository.findAll(cmsPageExample, pageable);
        final List<CmsPage> content = all.getContent();
        System.out.println(content);

    }
}
