package org.ouyushan.springboot.begin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description hello spring boot
 * @Author ouyushan
 * @Email ouyushan@hotmail.com
 * @Date 2020/4/27 9:54
 */

@RestController
@RequestMapping("/springboot")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello,Spring Boot!";
    }

}
