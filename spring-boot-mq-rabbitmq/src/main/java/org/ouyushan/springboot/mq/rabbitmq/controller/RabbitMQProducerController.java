package org.ouyushan.springboot.mq.rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/4 16:47
 */
@RestController
public class RabbitMQProducerController {
    private static Logger logger = LoggerFactory.getLogger(RabbitMQProducerController.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    /* 发送消息 */
    @RequestMapping(value = "/sendMsg")
    public void send(String msg) {
        this.amqpTemplate.convertAndSend("ouyushan.queue", msg);
        logger.info("msg:" + msg);
    }
}
