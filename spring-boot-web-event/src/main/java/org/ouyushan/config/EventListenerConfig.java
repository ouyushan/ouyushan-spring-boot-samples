package org.ouyushan.config;

import org.ouyushan.entity.Message;
import org.ouyushan.event.MessageEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @Description:事件监听器
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2021/2/26 11:26
 */
@Configuration
public class EventListenerConfig {

    /**
     * 监听所有事件
     *
     * @param event
     */
    @EventListener
    public void handleEvent(Object event) {

        if (event instanceof Message) {
            System.out.println("事件为：message");
        }

        System.out.println("event: " + event);
    }

    @EventListener
    public void handleMessageEvent(MessageEvent messageEvent){
        System.out.println("event: " + messageEvent.getMessage() + ":" + messageEvent.getTimestamp());
    }

    @EventListener(condition = "#messageEvent.message.code == 'oKong'")
    public void handleMessageEventByCondition(MessageEvent messageEvent){
        System.out.println("event: " + messageEvent.getMessage() + ":" + messageEvent.getTimestamp());
    }

}
