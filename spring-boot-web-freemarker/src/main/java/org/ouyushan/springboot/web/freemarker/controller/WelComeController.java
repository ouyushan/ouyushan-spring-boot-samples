package org.ouyushan.springboot.web.freemarker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/30 11:35
 */
@Controller
public class WelComeController {

    @Value("${application.message:Default Value Hello World}")
    private String message;

    @GetMapping("/")
    public String error(Map<String,Object> model){
        model.put("index",this.message);
        return "index";
    }

    @GetMapping("/hi")
    public String welcome(Model model){
        model.addAttribute("time",new Date());
        model.addAttribute("message",this.message);
        return "hello";
    }
}

