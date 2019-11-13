import com.xuecheng.TestRabbitApplication;
import com.xuecheng.config.RabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lxt
 * @date 2019-11-13-11:44
 */
@SpringBootTest(classes = TestRabbitApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitTemplate {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void testEmail() {

        String message = "send to email";

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPICS_INFORM, "inform.email", message);
    }
}
