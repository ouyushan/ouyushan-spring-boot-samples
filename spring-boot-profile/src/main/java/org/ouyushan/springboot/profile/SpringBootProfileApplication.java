package org.ouyushan.springboot.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SpringBootProfileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootProfileApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        System.out.println("server.port:" + environment.getProperty("server.port"));
    }

}
