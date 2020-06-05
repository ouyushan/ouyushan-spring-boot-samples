package org.ouyushan.springboot.data.jparepository.controller;

import org.ouyushan.springboot.data.jparepository.entity.UserInfo;
import org.ouyushan.springboot.data.jparepository.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 11:03
 */
@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查询个人信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getUser/{id}")
    public UserInfo getUserInfo(@PathVariable("id") Long id) {
        UserInfo userInfo = userInfoService.findUserInfo(id);
        if (userInfo == null) {
            throw new RuntimeException("查询为空");
        }
        return userInfo;
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @GetMapping(value = "/getUsers")
    public List<UserInfo> getUserInfoList() {
        List<UserInfo> userInfoList = this.userInfoService.findUserInfoList();
        if (userInfoList == null || userInfoList.size() == 0) {
            throw new RuntimeException("用户列表为空");
        }
        return userInfoList;
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @GetMapping(value = "/getUsersByPage")
    public Page<UserInfo> getUsersByPage() {
        Page<UserInfo> pageInfo = this.userInfoService.findAll();
        if (pageInfo == null || pageInfo.getTotalElements() == 0) {
            throw new RuntimeException("用户列表为空");
        }
        return pageInfo;
    }

    /**
     * 新增用户
     */
    @PostMapping(value = "/addUser")
    public void addUser(@RequestBody UserInfo userInfo) {
        try {
            this.userInfoService.add(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增用户失败");
        }
    }

    /**
     * 更新用户
     *
     * @param
     */
    @PutMapping(value = "/updateUser")
    public void update(@RequestBody UserInfo userInfo) {
        try {
            this.userInfoService.update(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        try {
            this.userInfoService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除用户：" + id + " 失败");
        }
    }

}
