package org.ouyushan.springboot.jta.atomikos.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 16:49
 */
@Component
public class MessagesListener {

    @JmsListener(destination = "accounts")
    public void onMessage(String content) {
        System.out.println("----> " + content);
    }

}
