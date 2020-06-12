package org.ouyushan.springboot.mq.kafka.controller;

import org.ouyushan.springboot.mq.kafka.entity.SampleMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 14:07
 */
@RestController
public class KafkaProducerController {


    private KafkaTemplate<Object, SampleMessage> kafkaTemplate;

    public KafkaProducerController(KafkaTemplate<Object, SampleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @RequestMapping("/sendMsg")
    public void sendMsg(SampleMessage message) {
        this.kafkaTemplate.send("testTopic", message);
        System.out.println("Sent sample message [" + message + "]");
    }

}
