# spring-boot-data-crudrepository
springboot中CrudRepository的使用

* 继承CrudRepository   编写Repository 接口类，使用@Query注解编写查询语句
* 在Controller中通过构造函数注入Repository接口

1.Spring Data JPA可以极大地简化JPA的写法，在几乎不用写接口实现的情况下完成对数据的访问和操作。

2.Spring Data通过提供Repository接口来约定数据访问的统一标准。

3.Repository接口下包含一些常用的子接口：

   CrudRepository、PagingAndSortingRepository、JpaRepository

   JpaRepository，它继承自PagingAndSortingRepository，而PagingAndSortingRepository又继承自CrudRepository。
每个都有自己的功能：
   CrudRepository提供CRUD的功能。
   PagingAndSortingRepository提供分页和排序功能
   JpaRepository提供JPA相关的方法，如刷新持久化数据、批量删除。
   由于三者之间的继承关系，所以JpaRepository包含了CrudRepository和PagingAndSortingRepository所有的API。

4.在进行spring boot 项目的开发中，开发者只需要定义自己项目的数据访问接口，然后实现Spring Data提供的这些接口，就可以实现对数据的CRUD操作。
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
```

Spring Boot可以自动配置嵌入式H2、HSQL和Derby数据库。
您不需要提供任何连接url,您只需要包含对希望使用的嵌入式数据库的构建依赖项。

默认数据源：HikariCP，其次Tomcat pooling DataSource，再次Commons DBCP2

默认采用h2数据库，在resources中定义以下文件
schema.sql      定义数据表
```
CREATE TABLE CUSTOMER (
  ID             INTEGER IDENTITY PRIMARY KEY,
  FIRST_NAME     VARCHAR(30),
  DATE_OF_BIRTH  DATE
);
```

data.sql    定义数据
```
INSERT INTO CUSTOMER (ID, FIRST_NAME, DATE_OF_BIRTH) values (1, 'Meredith', '1998-07-13');
INSERT INTO CUSTOMER (ID, FIRST_NAME, DATE_OF_BIRTH) values (2, 'Joan', '1982-10-29');
```


http://localhost:8080/?name
```
[
{
"id": 1,
"firstName": "Meredith",
"dateOfBirth": "1998-07-13"
},
{
"id": 2,
"firstName": "Joan",
"dateOfBirth": "1982-10-29"
}
]
```

http://localhost:8080/?name=Joan
```
[{"id":2,"firstName":"Joan","dateOfBirth":"1982-10-29"}]
```


