# 示例四 spring-boot-cors

* 对应例子：https://github.com/ouyushan/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-logback

* 对应文档：第26节 https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/

Web 开发经常会遇到跨域问题，解决方案有： jsonp， iframe,CORS 等等

CORS 与 JSONP 相比
1、 JSONP 只能实现 GET 请求，而 CORS 支持所有类型的 HTTP 请求。
2、 使用 CORS，开发者可以使用普通的 XMLHttpRequest 发起请求和获得数据，比起 JSONP 有更好的
错误处理。
3、 JSONP 主要被老的浏览器支持，它们往往不支持 CORS，而绝大多数现代浏览器都已经支持了 CORS




二、 在 spring MVC 中可以配置全局的规则，也可以使用@CrossOrigin 注解进行细粒度的配置



全局配置：方式一
```
package org.ouyushan.spring.boot.web.cors.config;

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


```

全局配置：方式二
```
package org.ouyushan.spring.boot.web.cors.config;

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

```
使用方法一、二配置之后再使用自定义拦截器时跨域相关配置就会失效。
原因是请求经过的先后顺序问题，当请求到来时会先进入拦截器中，而不是进入Mapping映射中，所以返回的头信息中并没有配置的跨域信息。浏览器就会报跨域异常。

正确的解决跨域问题的方法时使用CorsFilter过滤器。代码如下：
全局配置：方式三
```
package org.ouyushan.spring.boot.web.cors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Description: 常规方法配置之后再使用自定义拦截器时跨域相关配置就会失效，该配置能解决此问题。
 * 原因是请求经过的先后顺序问题，当请求到来时会先进入拦截器中，而不是进入Mapping映射中，所以返回的头信息中并没有配置的跨域信息。浏览器就会报跨域异常。
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/5 11:20
 */
@Configuration
public class GlobalCorsConfigurationWithFilter {

    private CorsConfiguration corsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
        return new CorsFilter(source);
    }
}

```




