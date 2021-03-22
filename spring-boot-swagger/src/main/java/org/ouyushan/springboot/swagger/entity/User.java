package org.ouyushan.springboot.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 实体类
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/11/13 9:15
 */
@ApiModel(value = "用户实体类")
public class User {

    @ApiModelProperty(value = "用户id",example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名称",example = "ouyushan")
    private String username;

    @ApiModelProperty(value = "年龄",example = "24")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    public User(Integer id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
