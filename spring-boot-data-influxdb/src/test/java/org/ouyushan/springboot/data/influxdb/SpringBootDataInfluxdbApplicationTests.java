package org.ouyushan.springboot.data.influxdb;

import org.influxdb.dto.QueryResult;
import org.junit.jupiter.api.Test;
import org.ouyushan.springboot.data.influxdb.config.InfluxDBConnect;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootDataInfluxdbApplicationTests {

    @Resource
    InfluxDBConnect influxDBConnect;

    @Test
    public void testInsert() {
        Map<String, String> tagsMap = new HashMap<>();
        Map<String, Object> fieldsMap = new HashMap<>();
        System.out.println("influxDB start time :" + System.currentTimeMillis());
        int i = 0;
        for (; ; ) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tagsMap.put("user_id", String.valueOf(i % 10));
            tagsMap.put("url", "http://www.baidu.com");
            tagsMap.put("service_method", "testInsert" + (i % 5));
            fieldsMap.put("count", i % 5);
            influxDBConnect.insert("usage", tagsMap, fieldsMap);
            i++;
        }
    }

    @Test
    public void testQuery() {
        QueryResult queryResult = influxDBConnect.query("select * from usage");
        queryResult.getResults().stream().forEach(result -> System.out.println(result.getSeries()));
    }


}
