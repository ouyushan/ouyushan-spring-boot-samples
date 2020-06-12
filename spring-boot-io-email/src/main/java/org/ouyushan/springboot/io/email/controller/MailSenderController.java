package org.ouyushan.springboot.io.email.controller;

import org.ouyushan.springboot.io.email.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 15:44
 */

@RestController
public class MailSenderController {

    @Autowired
    @Qualifier("simpleSender")
    private Sender simpleSender;

    @Autowired
    @Qualifier("htmlSender")
    private Sender htmlSender;

    @Autowired
    @Qualifier("attachSender")
    private Sender attachSender;

    @Autowired
    @Qualifier("innerAttachSender")
    private Sender innerAttachSender;


    @GetMapping("/simpleSender")
    public String simpleSender(){
        return simpleSender.sendMail();
    }

    @GetMapping("/htmlSender")
    public String htmlSender(){
        return htmlSender.sendMail();
    }

    @GetMapping("/attachSender")
    public String attachSender(){
        return attachSender.sendMail();
    }

    @GetMapping("/innerAttachSender")
    public String innerAttachSender(){
        return innerAttachSender.sendMail();
    }

}
