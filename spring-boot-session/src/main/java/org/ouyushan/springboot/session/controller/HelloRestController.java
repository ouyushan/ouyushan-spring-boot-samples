package org.ouyushan.springboot.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/11 19:03
 */
@RestController
public class HelloRestController {

    @GetMapping("/")
    String uid(HttpSession session) {
        return session.getId();
    }

}
