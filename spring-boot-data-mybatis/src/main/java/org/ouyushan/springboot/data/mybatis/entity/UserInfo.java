package org.ouyushan.springboot.data.mybatis.entity;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 14:10
 */
public class UserInfo {

    private Long id;

    private String userName;

    private String password;

    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

