package org.ouyushan.springboot.custom.servlet.config.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description: 自定义监听器
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/28 10:45
 */
//@WebListener
public class CustomListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("========contextInitialized========");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("========contextDestroyed========");
    }
}
