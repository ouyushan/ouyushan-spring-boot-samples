package org.ouyushan.springboot.data.cache;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class SpringBootDataCacheApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(SpringBootDataCacheApplication.class).profiles("app").run(args);
    }

}
