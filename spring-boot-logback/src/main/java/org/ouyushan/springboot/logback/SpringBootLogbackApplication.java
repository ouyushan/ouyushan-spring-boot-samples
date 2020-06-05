package org.ouyushan.springboot.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootLogbackApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootLogbackApplication.class);

    @PostConstruct
    public void logSomething(){
        logger.info("Sample Info Message");
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLogbackApplication.class, args);
    }

}
