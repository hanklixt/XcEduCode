package com.xuecheng.manage_cms.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxt
 * @date 2019-11-13-14:48
 */
@Configuration
public class RabbitmqConfig {

    //队列bean的名称
    public static final String QUEUE_CMS_POSTPAGE = "queue_cms_postpage";
    //交换机的名称
    public static final String EX_ROUTING_CMS_POSTPAGE = "ex_routing_cms_postpage";


    /**
     * 指定初始化交换机,且持久化
     *
     * @return
     */
    @Bean
    public Exchange exchange() {
        return ExchangeBuilder.directExchange(EX_ROUTING_CMS_POSTPAGE).durable(true).build();
    }
}
