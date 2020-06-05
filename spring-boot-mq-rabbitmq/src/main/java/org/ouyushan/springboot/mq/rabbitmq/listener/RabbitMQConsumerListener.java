package org.ouyushan.springboot.mq.rabbitmq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/4 16:46
 */
@Component
public class RabbitMQConsumerListener {
    private static Logger logger = LoggerFactory.getLogger(RabbitMQConsumerListener.class);
    /* 接收消息 */
    @RabbitListener(queues = "ouyushan.queue")
    public void receiveQueue(String text) {
        logger.info("接受到：" + text);
    }
}
