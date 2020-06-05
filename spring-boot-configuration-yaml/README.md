一、环境
1.1、Idea 2020.1
1.2、JDK 1.8

二、步骤
2.1、点击File -> New Project -> Spring Initializer，点击next

2.2、在对应地方修改自己的项目信息

2.3、选择Web依赖，选中Spring Web。可以选择Spring Boot版本，本次默认为2.2.6，点击Next

2.4、编辑工程名和项目路径，确定后点击Finish完成

2.5、项目结构

三、添加测试方法


3.1、新建UserController实体类
package org.ouyushan.springboot.configuration.properties.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/27 13:34
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value(value = "${ouyushan.secret}")
    private String secret;

    @Value(value = "${ouyushan.number}")
    private int number;

    @Value(value = "${ouyushan.desc}")
    private String desc;


    @GetMapping("/")
    public String hello() {
        return "Hello World Based On Spring-Boot";
    }

    // @RequestParam 简单类型的绑定
    @GetMapping("/getUser")
    public HashMap<String, Object> getUser(@RequestParam String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "hello world");
        map.put("username", username);
        map.put("secret",secret);
        map.put("number",number);
        map.put("desc",desc);
        return map;
    }
}


3.2、配置默认application.yaml
在resources/application.yaml中配置以下信息：
ouyushan:
  secret: ${random.value}
  number: ${random.int}
  name: ouyushan.org
  desc: ${ouyushan.name} is a domain name

server:
  port: 7070

spring:
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: Asia/Chongqing


启动项目，访问
http://localhost:7070/api/user/getUser?username=spring
返回：
{
    "number":1410493656,
    "secret":"f99e177aeb5370bec930ec7159bb5df7",
    "title":"hello world",
    "username":"spring",
    "desc":"ouyushan.org is a domain name"
}


3.3、配置resources/config/application.yaml
ouyushan:
  secret: ${random.value}
  number: ${random.int}
  name: ouyushan.org
  desc: config ${ouyushan.name} is a domain name

server:
  port: 9090

spring:
  jackson:
  date-format: yyyy-MM-dd HH:mm:ss
  time-zone: Asia/Chongqing

启动项目，访问
http://localhost:9090/api/user/getUser?username=spring
返回：
{
    "number":-1540619073,
    "secret":"352c725a9695f463f4edbcbd6dee1944",
    "title":"hello world",
    "username":"spring",
    "desc":"ouyushan-config is a domain name"
}


通过对比请求地址和返回结果，发现resources/config/application.properties中的配置内容已覆盖resources/application.properties

四、知识点

yaml文件优先级

1. 当前目录下的一个/config子目录
2. 当前目录
3. 一个classpath下的/config包
4. classpath根路径（root）

可通过@Value取值

    @Value(value = "${ouyushan.secret}")
    private String secret;


**@ConfigurationProperties(prefix = "sample")**

读取外部配置文件中sample 开始的属性，自动映射到类中的字段，并覆盖代码中的值。



当同名文件存在两种格式时，先加载yaml文件再加载properties文件，会导致properties的值会覆盖yaml配置的值