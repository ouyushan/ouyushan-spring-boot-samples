package org.ouyushan.springboot.security.oauth2.resoures.server.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/11 16:13
 */

@RestController
public class MessagesController {
    @GetMapping("/messages")
    public String[] getMessages() {
        String[] messages = new String[]{"Message 1", "Message 2", "Message 3"};
        return messages;
    }
}
