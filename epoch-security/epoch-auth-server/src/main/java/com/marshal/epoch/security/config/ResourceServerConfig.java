package com.marshal.epoch.security.config;


import com.marshal.epoch.security.constants.Oauth2EndpointConstant;
import com.marshal.epoch.security.properties.EpochSecurityProperties;
import com.marshal.epoch.security.handler.EpochAccessDeniedHandler;
import com.marshal.epoch.security.handler.EpochAuthenticationEntryPoint;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @auth: Marshal
 * @date: 2020/1/15
 * @desc: 资源服务器配置
 */
@Order(100)
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter implements Oauth2EndpointConstant {

    @Autowired
    private EpochAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private EpochAuthenticationEntryPoint exceptionEntryPoint;
    @Autowired
    private EpochSecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getAnonUrl(), ",");

        http.csrf().disable()
                .requestMatchers().antMatchers(ALL)
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers(OAUTH_ALL).permitAll()
                .antMatchers(ALL).authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
