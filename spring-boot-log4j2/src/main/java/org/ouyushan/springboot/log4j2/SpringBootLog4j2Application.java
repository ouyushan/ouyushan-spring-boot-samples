package org.ouyushan.springboot.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootLog4j2Application {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootLog4j2Application.class);

    @PostConstruct
    public void logSomething(){
        logger.info("Sample Info Message");
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }


    public static void main(String[] args) {
        logger.debug("===========debug==========");
        SpringApplication.run(SpringBootLog4j2Application.class, args);
        logger.debug("===========info==========");
    }

}
