package org.ouyushan.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2021/2/26 14:38
 */
public class MessageEventListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationEvent) {
        System.out.println("ApplicationStartingEvent事件发布：" + applicationEvent.getTimestamp());
    }
}
