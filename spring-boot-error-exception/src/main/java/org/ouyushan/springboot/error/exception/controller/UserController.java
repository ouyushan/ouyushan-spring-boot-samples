package org.ouyushan.springboot.error.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/7 14:41
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.put("title", "freemarker hello word");
        return "index"; // 开头不要加上/，linux下面会出错
    }

    @RequestMapping(value = "/runtimeException")
    public String runtimeException(ModelMap map) {
        throw new RuntimeException("测试异常");
    }

    @RequestMapping(value = "/error")
    public String error(ModelMap map) throws Exception {
        throw new Exception("测试错误");
    }
}
