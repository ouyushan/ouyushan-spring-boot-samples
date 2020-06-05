package org.ouyushan.springboot.data.mybatis.service;

import org.ouyushan.springboot.data.mybatis.dao.UserInfoDao;
import org.ouyushan.springboot.data.mybatis.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 14:16
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int add(UserInfo userInfo) {
        return this.userInfoDao.add(userInfo);
    }

    @Override
    public int update(UserInfo userInfo) {
        return this.userInfoDao.update(userInfo);
    }

    @Override
    public int delete(Long id) {
        return this.userInfoDao.delete(id);
    }

    @Override
    public UserInfo findUserInfo(Long id) {
        return this.userInfoDao.findUserInfo(id);
    }

    @Override
    public List<UserInfo> findUserInfoList() {
        return this.userInfoDao.findUserInfoList();
    }
}
