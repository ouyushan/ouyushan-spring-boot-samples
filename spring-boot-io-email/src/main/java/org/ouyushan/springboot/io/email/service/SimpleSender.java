package org.ouyushan.springboot.io.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 14:54
 */

@Service
public class SimpleSender implements Sender {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailProperties mailProperties;

    public String sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人邮箱
        message.setFrom(this.mailProperties.getUsername());
        // 收信人邮箱
        message.setTo("511932633@qq.com");
        // 邮件主题
        message.setSubject("简单邮件测试");
        // 邮件内容
        message.setText("简单邮件测试");
        this.javaMailSender.send(message);
        return "success";
    }
}
