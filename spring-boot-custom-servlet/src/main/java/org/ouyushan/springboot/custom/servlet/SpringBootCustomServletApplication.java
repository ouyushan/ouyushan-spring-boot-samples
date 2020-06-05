package org.ouyushan.springboot.custom.servlet;

import org.ouyushan.springboot.custom.servlet.config.filter.CustomFilter;
import org.ouyushan.springboot.custom.servlet.config.listener.CustomListener;
import org.ouyushan.springboot.custom.servlet.config.servlet.CustomServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

// 方式一 通过bean注入
/*
@SpringBootApplication
public class SpringBootCustomServletApplication {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        // 只有路径是以/custom/servlet开始的才会触发
        return new ServletRegistrationBean(new CustomServlet(), "/custom/servlet");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        //第二个参数为需要拦截的路径，不传则拦截所有
        return new FilterRegistrationBean(new CustomFilter(), servletRegistrationBean());
    }

    @Bean
    public ServletListenerRegistrationBean<CustomListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<CustomListener>(new CustomListener());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCustomServletApplication.class, args);
    }

}
*/

// 方式二 通过实现ServletContextInitializer
@SpringBootApplication
public class SpringBootCustomServletApplication implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        // 创建Servlet,并映射访问路径为/custom/servlet
        servletContext.addServlet("customServlet", new CustomServlet()).addMapping("/custom/servlet");

        // 创建Filter，拦截的Servlet
        servletContext.addFilter("customFilter", new CustomFilter())
                .addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");

        // 设置自定义filter
        servletContext.addListener(new CustomListener());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCustomServletApplication.class, args);
    }
}


/*@ServletComponentScan
@SpringBootApplication
public class SpringBootCustomServletApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCustomServletApplication.class, args);
    }
}*/
