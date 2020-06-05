package org.ouyushan.spring.boot.data.mongodb;

import org.junit.jupiter.api.Test;
import org.ouyushan.spring.boot.data.mongodb.entity.User;
import org.ouyushan.spring.boot.data.mongodb.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringBootDataMongodbApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setId(1L);
        user.setName("ouyuhsan");
        user.setCreateTime(new Date());
        userDao.insert(user);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(1L);
        user.setName("ouyuhsan-new");
        user.setCreateTime(new Date());
        userDao.updateById(user);
    }

    @Test
    public void testSelectUserById(){
        User user = userDao.selectById(1L);
        System.out.println(user.toString());
    }

}
