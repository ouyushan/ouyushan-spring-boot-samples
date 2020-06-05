package org.ouyushan.springboot.mq.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * @Description: JMS 配置队列
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/4 15:16
 */

@Configuration
@EnableJms
public class JmsConfiguration {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("ouyushan.queue");
    }
}
