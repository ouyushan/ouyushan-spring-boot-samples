package org.ouyushan.springboot.data.mybatis.service;

import org.ouyushan.springboot.data.mybatis.entity.UserInfo;

import java.util.List;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 14:15
 */
public interface UserInfoService {

    int add(UserInfo userInfo);

    int update(UserInfo userInfo);

    int delete(Long id);

    UserInfo findUserInfo(Long id);

    List<UserInfo> findUserInfoList();
}
