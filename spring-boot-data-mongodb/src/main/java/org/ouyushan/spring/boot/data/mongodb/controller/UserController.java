package org.ouyushan.spring.boot.data.mongodb.controller;

import org.ouyushan.spring.boot.data.mongodb.entity.User;
import org.ouyushan.spring.boot.data.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/2 16:54
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public User getUser(User user) {
        return userService.insert(user);
    }

    @RequestMapping("/delete")
    public void removeUser(Long id) {
        userService.deleteById(id);
    }

    @RequestMapping("/update")
    public void updateUser(User user) {
        userService.updateById(user);
    }

    @RequestMapping("/select")
    public User getUser(Long id) {
        return userService.selectById(id);
    }

}

