自spring-boot 2.0开始，spring-boot-autoconfigure提供了influxdb的简单集成实现类InfluxDbAutoConfiguration. 该类生效条件为@ConditionalOnClass(InfluxDB.class)，所以只要引入influxdb-java依赖，就会自动生效。



http://localhost:8080/actuator



http://localhost:8080/actuator/health