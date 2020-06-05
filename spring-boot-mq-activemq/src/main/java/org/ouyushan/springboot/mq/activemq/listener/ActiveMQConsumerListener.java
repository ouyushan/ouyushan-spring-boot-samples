package org.ouyushan.springboot.mq.activemq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @Description: 消费监听
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/4 15:26
 */

@Component
public class ActiveMQConsumerListener {
    private static Logger logger = LoggerFactory.getLogger(ActiveMQConsumerListener.class);

    /* 自动注入JmsConfiguration中定义的queue (ouyushan.queue)*/
    @Autowired
    private Queue queue;

    /* 接收消息 */
    @JmsListener(destination = "ouyushan.queue")
    public void receiveQueue(String text) {
        logger.info("接受到：" + text);
    }
}
