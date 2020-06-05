package org.ouyushan.springboot.security.oauth2.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @Description: 客户端配置
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/11 16:21
 */
@Configuration
@EnableOAuth2Client
public class OAuth2ClientConfig {

    @ConfigurationProperties(prefix = "security.oauth2.client.messaging-client-auth-code")
    @Bean
    public OAuth2ProtectedResourceDetails messagingClientAuthCodeDetails() {
        return new AuthorizationCodeResourceDetails();
    }

    @ConfigurationProperties(prefix = "security.oauth2.client.messaging-client-client-creds")
    @Bean
    public OAuth2ProtectedResourceDetails messagingClientClientCredsDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @ConfigurationProperties(prefix = "security.oauth2.client.messaging-client-password")
    @Bean
    public OAuth2ProtectedResourceDetails messagingClientPasswordDetails() {
        return new ResourceOwnerPasswordResourceDetails();
    }

    @Bean
    public OAuth2RestTemplate messagingClientAuthCodeRestTemplate(
            @Qualifier("messagingClientAuthCodeDetails") OAuth2ProtectedResourceDetails resourceDetails,
            OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resourceDetails, oauth2ClientContext);
    }

    @Bean
    public OAuth2RestTemplate messagingClientClientCredsRestTemplate(
            @Qualifier("messagingClientClientCredsDetails") OAuth2ProtectedResourceDetails resourceDetails) {
        return new OAuth2RestTemplate(resourceDetails);
    }

    @Bean
    public OAuth2RestTemplate messagingClientPasswordRestTemplate(
            @Qualifier("messagingClientPasswordDetails") OAuth2ProtectedResourceDetails resourceDetails) {
        return new OAuth2RestTemplate(resourceDetails);
    }
}