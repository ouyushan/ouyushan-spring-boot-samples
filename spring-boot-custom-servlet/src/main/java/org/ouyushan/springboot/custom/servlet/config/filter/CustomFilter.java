package org.ouyushan.springboot.custom.servlet.config.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description: 自定义fileter
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/28 10:38
 */

//@WebFilter(filterName = "customFilter", urlPatterns = "/*")
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("========init filter========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========do filter========");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("========destroy filter========");
    }
}
