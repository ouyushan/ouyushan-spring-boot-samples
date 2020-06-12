package org.ouyushan.springboot.io.email.service;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 15:33
 */

@Service
public class AttachSender implements Sender{

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailProperties mailProperties;

    @Override
    public String sendMail() {
        try {
            MimeMessage message = this.javaMailSender.createMimeMessage();
            // 第二个参数表示是否开启multipart模式
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(this.mailProperties.getUsername());
            messageHelper.setTo("503742782@qq.com");
            messageHelper.setSubject("带附件的邮件测试");
            // 第二个参数表示是否html，设为true
            messageHelper.setText("<h1>HTML内容..</h1>", true);
            messageHelper.addAttachment("附件名称",
                    new ClassPathResource("banner.gif"));

            this.javaMailSender.send(message);
            return "success";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "false";
    }
}
