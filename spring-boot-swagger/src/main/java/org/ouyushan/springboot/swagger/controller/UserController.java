package org.ouyushan.springboot.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ouyushan.springboot.swagger.entity.User;
import org.ouyushan.springboot.swagger.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/11/12 20:53
 */

@Api("用户查询接口")
@RestController("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("getById")
    @ApiOperation(value = "根据用户id查询")
    public User getUserById(Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("getUserList")
    @ApiOperation(value = "根据用户列表")
    public List<User> getUserList() {
        return userService.getUserList();
    }

}
