package org.ouyushan.springboot.data.jparepository.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @Description: 需指定扫描japRepositories路径和entiry路径
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 10:00
 */

@Configuration
@EnableJpaRepositories("org.ouyushan.springboot.data.jparepository")
@EntityScan("org.ouyushan.springboot.data.jparepository.entity")
public class JPAConfig {

    /* <!-- 解决json与hibernate懒加载引起的问题 --> */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {

        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.configure(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION, false);

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = jsonConverter.getObjectMapper();
        objectMapper.registerModule(new Hibernate5Module());

        return jsonConverter;
    }
}
