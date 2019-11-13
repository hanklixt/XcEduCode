package com.xuecheng.listener;

import com.rabbitmq.client.Channel;
import com.xuecheng.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lxt
 * @date 2019-11-13-13:10
 */
@Component
public class ReceiveHandler {
    @RabbitListener(queues = {RabbitConfig.QUEUE_INFORM_EMAIL})
    public void receiveEmail(String msg, Message message, Channel channel) {
        System.out.println(msg);
    }
}
