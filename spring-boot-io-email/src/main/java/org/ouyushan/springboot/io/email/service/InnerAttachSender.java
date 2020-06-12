package org.ouyushan.springboot.io.email.service;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 15:37
 */
@Service
public class InnerAttachSender implements Sender {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private Configuration freemarkerConfiguration;

    @Override
    public String sendMail() {
        try {
            MimeMessage message = this.javaMailSender.createMimeMessage();
            // 第二个参数表示是否开启multipart模式
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(this.mailProperties.getUsername());
            messageHelper.setTo("511932633@qq.com");
            messageHelper.setSubject("基于freemarker模板的邮件测试");

            Map<String, Object> model = new HashMap<>();
            model.put("username", "itmuch");
            model.put("event", "IT牧场大事件");
            String content = null;
            content = FreeMarkerTemplateUtils.processTemplateIntoString(
                    this.freemarkerConfiguration.getTemplate("mail.ftl"), model);
            // 第二个参数表示是否html，设为true
            messageHelper.setText(content, true);
            this.javaMailSender.send(message);
            return "success";

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "false";
    }
}
