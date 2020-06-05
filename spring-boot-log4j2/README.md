
Spring Boot使用Commons Logging进行所有内部日志记录，但保留底层日志实现。
为Java Util Logging，Log4J2和 Logback提供了默认配置 。
在每种情况下，记录器都预先配置为使用控制台输出，并且还提供可选的文件输出。

默认情况下，如果使用“Starters”，则使用Logback进行日志记录。还包括适当的Logback路由，
以确保使用Java Util Logging，Commons Logging，Log4J或SLF4J的依赖库都能正常工作。

当使用log4j2时，先排除logging依赖，再引入log4j2
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<!-- 使用log4j2 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-log4j2</artifactId>
		</dependency>
```