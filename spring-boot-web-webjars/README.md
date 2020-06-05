静态资源
1.静态资源目录
SpringBoot默认配置下，提供了以下几个静态资源目录：

/static：classpath:/static/

/public：classpath:/public/

/resources：classpath:/resources/

/META-INF/resources：classpath:/META-INF/resources/

当然，可以通过spring.resources.static-locations配置指定静态文件的位置。

    #配置静态资源
    spring:
      resources:
        #指定静态资源目录
        static-locations: classpath:/mystatic/

2.favicon.ico图标
如果在配置的静态资源目录中有favicon.ico文件，SpringBoot会自动将其设置为应用图标。

3.欢迎页面
SpringBoot支持静态和模板欢迎页，它首先在静态资源目录查看index.html文件做为首页，若未找到则查找index模板。