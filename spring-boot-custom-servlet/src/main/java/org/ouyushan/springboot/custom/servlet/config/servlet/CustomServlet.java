package org.ouyushan.springboot.custom.servlet.config.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 自定义servlet
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/28 10:25
 */

//@WebServlet(name = "customServlet", urlPatterns = "/custom/servlet")
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("========servlet get method is called========");
        resp.getWriter().write("hello world by get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("========servlet post method is called========");
        resp.getWriter().write("hello world by post");
    }
}
