package org.ouyushan.spring.boot.data.mongodb.service;

import org.ouyushan.spring.boot.data.mongodb.entity.User;
import org.ouyushan.spring.boot.data.mongodb.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/2 16:53
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User insert(User user){
        return userDao.insert(user);
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }

    public void updateById(User user){
        userDao.updateById(user);
    }

    public User selectById(Long id){
        return userDao.selectById(id);
    }

}
