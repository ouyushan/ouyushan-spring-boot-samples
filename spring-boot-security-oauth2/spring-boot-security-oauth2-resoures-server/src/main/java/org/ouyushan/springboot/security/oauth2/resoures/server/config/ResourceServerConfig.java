package org.ouyushan.springboot.security.oauth2.resoures.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/11 15:41
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "messages-resource";

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer security) throws Exception {
        security
                .resourceId(RESOURCE_ID)
                .tokenStore(this.tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/messages/**")
                .authorizeRequests()
                .antMatchers("/messages/**").access("#oauth2.hasScope('message.read')");
    }
}