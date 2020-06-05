package org.ouyuhsan.springboot.web.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootWebUploadApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootWebUploadApplication.class);


    @PostConstruct
    public void logSomething(){
        logger.info("Sample Info Message");
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebUploadApplication.class, args);
    }

}
