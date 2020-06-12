package org.ouyushan.springboot.mq.kafka.listener;

import org.ouyushan.springboot.mq.kafka.entity.SampleMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 14:01
 */
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "testTopic")
    public void processMessage(SampleMessage message) {
        System.out.println("Received sample message [" + message + "]");
    }

}
