package org.ouyushan.event;

import org.ouyushan.entity.Message;
import org.springframework.context.ApplicationEvent;

/**
 * @Description: 事件源
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2021/2/26 11:21
 */
public class MessageEvent extends ApplicationEvent {

    private Message message;

    public Message getMessage() {
        return message;
    }

    public MessageEvent(Object source,Message message) {
        super(source);
        this.message = message;
    }
}
