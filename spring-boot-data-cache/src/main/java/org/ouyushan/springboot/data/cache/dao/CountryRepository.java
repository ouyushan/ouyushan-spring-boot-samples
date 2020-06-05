package org.ouyushan.springboot.data.cache.dao;

import org.ouyushan.springboot.data.cache.entity.Country;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Description: 通过注解@CacheConfig配置缓存名称
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 15:26
 */
@Component
// 配置缓存名称
@CacheConfig(cacheNames = "countries")
public class CountryRepository {

    @Cacheable
    public Country findByCode(String code) {
        System.out.println("---> Loading country with code '" + code + "'");
        return new Country(code);
    }

}
