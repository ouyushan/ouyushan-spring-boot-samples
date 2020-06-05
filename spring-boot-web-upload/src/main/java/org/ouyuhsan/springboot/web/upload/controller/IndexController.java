package org.ouyuhsan.springboot.web.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/6 11:40
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/error")
    public String error(ModelMap map) {
        throw new RuntimeException("测试异常");
    }
}
