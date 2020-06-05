package org.ouyushan.springboot.mq.activemq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/4 15:31
 */
@RestController
public class ActiveMQProducerController {
    private static Logger logger = LoggerFactory.getLogger(ActiveMQProducerController.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /* 自动注入JmsConfiguration中定义的queue (ouyushan.queue)*/
    @Autowired
    private Queue queue;

    /* 发送消息 */
    @RequestMapping(value = "/sendMsg")
    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
        logger.info("msg:" + msg);
    }
}
