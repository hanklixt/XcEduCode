import com.xuecheng.manage_cms.ManageCmsApplication;
import com.xuecheng.manage_cms.service.CmsService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lxt
 * @date 2019-11-04-16:26
 */
@SpringBootTest(classes = ManageCmsApplication.class)
@RunWith(SpringRunner.class)
public class TestGenerateHtml {

    @Autowired
    private CmsService cmsService;

    @org.junit.Test
    public void test() {
        String pageId = "5dca4688a201f13e10cb6f93";
        final String html = cmsService.getHtmlByPageId(pageId);
        System.out.println(html);

    }
}
