package com.xuecheng.client.listener;

import com.alibaba.fastjson.JSON;
import com.xuecheng.client.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lxt
 * @date 2019-11-13-16:32
 */
@Component
@Slf4j
public class CmsRabbitListener {

    @Autowired
    private PageService pageService;

    @RabbitListener(queues = {"${xuecheng.mq.queue}"})
    public void pageHandle(String message) {
        final Map map = JSON.parseObject(message, Map.class);
        final String pageId = (String) map.get("pageId");
        pageService.savePageToServerPath(pageId);
        log.info("receive message:{}", pageId);
    }

}
