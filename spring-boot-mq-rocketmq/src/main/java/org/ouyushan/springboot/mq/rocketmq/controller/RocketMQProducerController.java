package org.ouyushan.springboot.mq.rocketmq.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 11:51
 */
@RestController
public class RocketMQProducerController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(String msg) {
        rocketMQTemplate.convertAndSend("test-topic", msg);
        return "success";
    }
}
