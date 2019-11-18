import com.xuecheng.course.manage.CourseManageApplication;
import com.xuecheng.course.manage.mapper.TeachplanMapper;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lxt
 * @date 2019-11-15-11:47
 */
@SpringBootTest(classes = CourseManageApplication.class)
@RunWith(value = SpringRunner.class)
public class Test {

    @Autowired
    TeachplanMapper teachplanMapper;

    @org.junit.Test
    public void test() {
        final TeachplanNode teachplanNode = teachplanMapper.selectNodeList("4028e581617f945f01617f9dabc40000");
        System.out.println(teachplanNode);
    }
}
