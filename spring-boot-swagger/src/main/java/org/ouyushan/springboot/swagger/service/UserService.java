package org.ouyushan.springboot.swagger.service;

import org.ouyushan.springboot.swagger.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: service服务类
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/11/13 9:20
 */
@Service
public class UserService {

    private List<User> userList = new ArrayList<>();
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {

        User user1 = new User(1, "jack", 23);
        User user2 = new User(2, "jimmy", 24);
        User user3 = new User(3, "tom", 25);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userMap = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
    }


    public User getUserById(Integer userId) {
        return userMap.getOrDefault(userId, new User());
    }

    public List<User> getUserList() {
        return userList;
    }
}
