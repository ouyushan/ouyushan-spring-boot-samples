package org.ouyushan.springboot.web.cors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description: 方式二：CORS全局设置 通过继承实现CORS全局设置
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/5 11:18
 */
@Configuration
public class GlobalCorsConfigurationAdapter extends WebMvcConfigurationSupport {
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}
