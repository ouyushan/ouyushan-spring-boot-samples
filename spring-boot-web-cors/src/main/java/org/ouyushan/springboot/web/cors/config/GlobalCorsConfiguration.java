package org.ouyushan.springboot.web.cors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 方式一：CORS全局设置 注入bean
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/5 11:07
 */

@Configuration
public class GlobalCorsConfiguration {
    @Bean
    public WebMvcConfigurer corsConfiguration() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST", "DELETE", "PUT")
                        .maxAge(3600);
            }
        };
    }
}
