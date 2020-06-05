package org.ouyushan.springboot.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/7 13:54
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.put("title", "freemarker hello word");
        return "index"; // 开头不要加上/，linux下面会出错
    }

    @RequestMapping(value = "/error")
    public String error(ModelMap map) {
        throw new RuntimeException("测试异常");
    }
}
