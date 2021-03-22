package org.ouyushan;

import org.ouyushan.listener.MessageEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootWebEventApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootWebEventApplication.class);
        springApplication.addListeners(new MessageEventListener());
        springApplication.run(args);
    }

}
