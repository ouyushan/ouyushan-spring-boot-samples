package org.ouyushan.springboot.data.mybatis.controller;

import org.ouyushan.springboot.data.mybatis.entity.UserInfo;
import org.ouyushan.springboot.data.mybatis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 14:51
 */
@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查询个人信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    public UserInfo getUserInfo(@PathVariable("id") Long id){
        UserInfo userInfo = userInfoService.findUserInfo(id);
        if (userInfo == null){
            throw new RuntimeException("查询为空");
        }
        return userInfo;
    }

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public List<UserInfo> getUserInfoList(){
        List<UserInfo> userInfoList = this.userInfoService.findUserInfoList();
        if(userInfoList == null || userInfoList.size() == 0){
            throw new RuntimeException("用户列表为空");
        }
        return userInfoList;
    }

    /**
     * 新增用户
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserInfo userInfo){
        try {
            this.userInfoService.add(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增用户失败");
        }
    }

    /**
     * 更新用户
     * @param userInfo
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public void update(@RequestBody UserInfo userInfo){
        try {
            this.userInfoService.update(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        try {
            this.userInfoService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除用户：" + id + " 失败");
        }
    }

}
