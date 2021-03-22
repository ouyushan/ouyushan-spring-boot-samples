package org.ouyushan.controller;

import org.ouyushan.entity.Message;
import org.ouyushan.event.MessageEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2021/2/26 13:50
 */

@RestController
@RequestMapping("/push")
public class EventController {

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/message")
    public String pushMessage(String code, String message) {
        System.out.println("发布applicationEvent事件:" + code + message);
        Message msg = new Message("success","200");
        eventPublisher.publishEvent(new MessageEvent(this, msg));
        return "事件发布成功";
    }

    @GetMapping("/object")
    public String pushObject(String code, String message) {
        System.out.println("发布applicationEvent事件:" + code + message);
        Message msg = new Message("success","200");
        eventPublisher.publishEvent(msg);
        return "事件发布成功";
    }
}
