package org.ouyushan.springboot.data.jparepository.service;

import org.ouyushan.springboot.data.jparepository.entity.UserInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 10:58
 */
public interface UserInfoService {

    UserInfo add(UserInfo userInfo);

    int update(UserInfo userInfo);

    void delete(Long id);

    UserInfo findUserInfo(Long id);

    List<UserInfo> findUserInfoList();

    Page<UserInfo> findAll();
}
