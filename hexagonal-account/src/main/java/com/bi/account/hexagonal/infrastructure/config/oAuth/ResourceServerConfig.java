package com.bi.account.hexagonal.infrastructure.config.oAuth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${config.security.oauth.jwt.key}")
    private String jwtKey;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore1());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth/**", "/login").permitAll()
                .antMatchers(HttpMethod.GET,"/api/accounts/","/users").permitAll()
                .antMatchers(HttpMethod.GET, "/api/accounts/{identification}",
                        "/api/movements","/users/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers("/api/accounts/**","/api/movements/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Bean
    public JwtTokenStore tokenStore1() {
        return new JwtTokenStore(accessTokenConverter1());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter1() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(jwtKey);
        return tokenConverter;
    }
}
