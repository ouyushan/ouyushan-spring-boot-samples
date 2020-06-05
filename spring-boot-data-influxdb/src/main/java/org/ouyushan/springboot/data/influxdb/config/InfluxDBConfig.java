package org.ouyushan.springboot.data.influxdb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/3 15:15
 */

@Configuration
@Slf4j
public class InfluxDBConfig {

    @Autowired
    private InfluxDBProperties influxDBProperties;


    @Bean
    public InfluxDBConnect getInfluxDBConnect() {
        InfluxDBConnect influxDB = new InfluxDBConnect(influxDBProperties.getUser(), influxDBProperties.getPassword(),
                influxDBProperties.getUrl(), influxDBProperties.getDatabase(), influxDBProperties.getRetentionPolicy(),
                influxDBProperties.getRetentionPolicyTime());

        influxDB.influxDbBuild();

        influxDB.createRetentionPolicy();
        log.info("init influxdb::[{}]", influxDBProperties);
        return influxDB;
    }

}
