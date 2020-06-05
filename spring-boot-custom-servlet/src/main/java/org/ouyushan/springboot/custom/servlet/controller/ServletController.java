package org.ouyushan.springboot.custom.servlet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/28 10:55
 */
@RestController
@RequestMapping("/api")
public class ServletController {

    @RequestMapping("/servlet")
    public String servlet() {
        return "custom servlet";
    }

    @RequestMapping("/filter")
    public String filter() {
        return "custom filter";
    }
}
