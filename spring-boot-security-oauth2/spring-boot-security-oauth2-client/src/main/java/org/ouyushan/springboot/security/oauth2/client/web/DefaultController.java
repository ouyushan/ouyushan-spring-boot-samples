package org.ouyushan.springboot.security.oauth2.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/11 17:25
 */
@Controller
public class DefaultController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return login();
    }
}