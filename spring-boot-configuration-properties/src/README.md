# 示例  spring-boot-configuration-properties  外部化配置


properties文件优先级

1. 当前目录下的一个/config子目录
2. 当前目录
3. 一个classpath下的/config包
4. classpath根路径（root）

可通过@Value取值

    @Value(value = "${ouyushan.secret}")
    private String secret;


**@ConfigurationProperties(prefix = "sample")**

读取外部配置文件中sample 开始的属性，自动映射到类中的字段，并覆盖代码中的值。