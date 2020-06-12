package org.ouyushan.springboot.mq.rocketmq.listener;

import org.springframework.stereotype.Component;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 11:33
 */
@Component

@RocketMQMessageListener(consumerGroup = "my-consumer_test-topic", topic = "test-topic")
public class RocketMQConsumerListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.err.println("接收到消息：" + message);
    }
}