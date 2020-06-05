package org.ouyushan.springboot.data.influxdb.config;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/3 16:00
 */
@Configuration
@ConfigurationProperties(prefix = "spring.influx")
@Data
public class InfluxDBProperties {
    @URL
    private String url;
    @NotBlank
    private String user;
    @NotBlank
    private String password;
    @NotBlank
    private String database;
    @NotBlank
    private String retentionPolicy;
    @NotBlank
    private String retentionPolicyTime;

}
