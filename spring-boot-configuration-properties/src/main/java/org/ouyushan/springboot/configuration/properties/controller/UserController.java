package org.ouyushan.springboot.configuration.properties.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/27 13:34
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value(value = "${ouyushan.secret}")
    private String secret;

    @Value(value = "${ouyushan.number}")
    private int number;

    @Value(value = "${ouyushan.desc}")
    private String desc;


    @GetMapping("/")
    public String hello() {
        return "Hello World Based On Spring-Boot";
    }

    // @RequestParam 简单类型的绑定
    @GetMapping("/getUser")
    public HashMap<String, Object> getUser(@RequestParam String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "hello world");
        map.put("username", username);
        map.put("secret",secret);
        map.put("number",number);
        map.put("desc",desc);
        return map;
    }


}
