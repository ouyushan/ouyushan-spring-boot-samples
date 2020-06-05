package org.ouyushan.springboot.data.redis.lettuce;

import org.junit.jupiter.api.Test;
import org.ouyushan.springboot.data.redis.lettuce.entity.UserInfo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootDataRedisLettuceApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStringRedisTemplateForObject() {
        stringRedisTemplate.opsForValue().set("keyString", "valueString");
        String value = stringRedisTemplate.opsForValue().get("keyString");
        System.out.println(value);
        assertThat(value).isEqualTo("valueString");
    }

    @Test
    public void testRedisTemplateForObject() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(24);
        userInfo.setId(1L);
        userInfo.setUserName("username");
        userInfo.setPassword("password");

        redisTemplate.opsForValue().set("object", userInfo);
        UserInfo userInfoFromRedis = (UserInfo) redisTemplate.opsForValue().get("object");
        System.out.println(userInfoFromRedis);
    }

    @Test
    public void testRedisTemplateForList() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setAge(11);
        userInfo1.setId(1L);
        userInfo1.setUserName("username");
        userInfo1.setPassword("password");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setAge(21);
        userInfo2.setId(2L);
        userInfo2.setUserName("username");
        userInfo2.setPassword("password");

        List<UserInfo> list = new ArrayList<>();
        list.add(userInfo1);
        list.add(userInfo2);

        redisTemplate.opsForValue().set("list", list);
        List<UserInfo> userInfoFromRedis = (List) redisTemplate.opsForValue().get("list");
        System.out.println(userInfoFromRedis);
    }

    @Test
    public void testRedisTemplateForMap() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setAge(11);
        userInfo1.setId(1L);
        userInfo1.setUserName("username");
        userInfo1.setPassword("password");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setAge(22);
        userInfo2.setId(2L);
        userInfo2.setUserName("username");
        userInfo2.setPassword("password");

        Map<String, UserInfo> map = new HashMap<>();
        map.put("userInfo1", userInfo1);
        map.put("userInfo2", userInfo2);

        redisTemplate.opsForValue().set("map", map);
        Map<String, UserInfo> userInfoFromRedis = (Map<String, UserInfo>) redisTemplate.opsForValue().get("map");
        System.out.println(userInfoFromRedis);
    }

}
