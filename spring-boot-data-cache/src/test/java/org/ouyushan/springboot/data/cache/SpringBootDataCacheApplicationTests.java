package org.ouyushan.springboot.data.cache;

import org.junit.jupiter.api.Test;
import org.ouyushan.springboot.data.cache.dao.CountryRepository;
import org.ouyushan.springboot.data.cache.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootDataCacheApplicationTests {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void validateCache() {
        Cache countries = this.cacheManager.getCache("countries");
        assertThat(countries).isNotNull();
        countries.clear(); // Simple test assuming the cache is empty
        assertThat(countries.get("BE")).isNull();
        Country be = this.countryRepository.findByCode("BE");
        assertThat((Country) countries.get("BE").get()).isEqualTo(be);
    }
}
