## 1、项目名称：
```
spring-boot-banner
```
## 2、相关概念：
* spring boot banner 可以是文本也可以是动画，同时存在时动画优先于文本显示。
* spring boot 启动时会默认从classpath中加载banner.txt，若存在则打印里面的内容。
* banner.txt中可包含以下等变量：
```
${application.version}
${application.formatted-version}
${spring-boot.version}
${spring-boot.formatted-version}
${application.title}
```

* 通过以下配置来指定banner文本文件的位置，默认在根目录下，如resources

```
spring.banner.location=/txt/banner.txt
```

* 通过以下配置来指定banner文本文件的编码，默认UTF-8
```
spring.banner.charset
```

* 支持的图片文件为banner.gif、banner.jpg和banner.png。图片文件会被转换为ASCII art，并优先于文本banner展示。
* 通过以下配置来指定banner图像文件的位置，默认在根目录下，如resources
```
spring.banner.image.location=/image/banner.gif
```

* 通过以下配置来指定banner状态和级别，不配置时默认开启console
```
# spring.main.banner-mode=console
# spring.main.banner-mode=log
## 关闭banner
# spring.main.banner-mode=off
```

## 3、sample实现
* 文本banner
在resources下新建文件banner.txt
```
.__           .__  .__                               .__       .___
|  |__   ____ |  | |  |   ____   __  _  _____________|  |    __| _/
|  |  \_/ __ \|  | |  |  /  _ \  \ \/ \/ /  _ \_  __ \  |   / __ |
|   Y  \  ___/|  |_|  |_(  <_> )  \     (  <_> )  | \/  |__/ /_/ |
|___|  /\___  >____/____/\____/    \/\_/ \____/|__|  |____/\____ |
     \/     \/                                                  \/

spring-boot.version ： ${spring-boot.version}
spring-boot.formatted-version ：${spring-boot.formatted-version}
```
打印信息
```

.__           .__  .__                               .__       .___
|  |__   ____ |  | |  |   ____   __  _  _____________|  |    __| _/
|  |  \_/ __ \|  | |  |  /  _ \  \ \/ \/ /  _ \_  __ \  |   / __ |
|   Y  \  ___/|  |_|  |_(  <_> )  \     (  <_> )  | \/  |__/ /_/ |
|___|  /\___  >____/____/\____/    \/\_/ \____/|__|  |____/\____ |
     \/     \/                                                  \/

spring-boot.version ： 2.2.6.RELEASE
spring-boot.formatted-version ： (v2.2.6.RELEASE)
```

* 图片banner
在resources下保存spring官方banner.gif

