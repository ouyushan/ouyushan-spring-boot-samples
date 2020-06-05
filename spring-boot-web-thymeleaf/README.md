# 示例十 spring-boot-web-thymeleaf
springboot中thymeleaf模板的使用

* 对应例子：

* 对应文档：第29.1.10节 https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/

页面模板存放在templates中

### Controller
* 使用了@PathVariable 从路径中获取参数,注入参数中必须有一属性名称与PathVariable变量名称相同
* 使用params处理路径中请求参数
* 使用@Valid校验参数，BindingResult 存储校验错误，RedirectAttributes 缓存上级页面参数

### Dao

* 利用ConcurrentHashMap模拟线程安全数据库
    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long,Message> messages = new ConcurrentHashMap<>();

### application启动配置类
* 定义了messageDao bean以及messageConverter bean
* @SpringBootApplication same as @Configuration @EnableAutoConfiguration @ComponentScan


post方式 create
localhost:8080?id=1&text=text&summary=summary

get查询id=1
http://localhost:8080/1

@GetMapping(params = "form")
localhost:8080?form=&id=1

localhost:8080?form=&id=1&text=text&summary=summary

```
${}  变量表达式（美元表达式，哈哈），用于访问容器上下文环境中的变量，功能同jstl中${}。
*{}  选择表达式（星号表达式）。选择表达式与变量表达式有一个重要的区别：选择表达式计算的是选定的对象，而不是整个环境变量映射
#{}  消息表达式（井号表达式，properties资源表达式）。通常与th:text属性一起使用，指明声明了th:text的标签的文本是#{}中的key所对应的value，而标签内的文本将不会显示
@{}  超链接url表达式
#maps 工具对象表达式。常用于日期、集合、数组对象的访问
#dates
#calendars
#numbers 
#strings
#objects
#bools
#arrays
#lists
#sets

```

