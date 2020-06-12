package org.ouyushan.springboot.mq.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/8 10:18
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue kinsonQueue() {
        return new Queue("ouyushan.queue");
    }

}
