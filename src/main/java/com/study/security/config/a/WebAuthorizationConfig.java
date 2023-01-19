package com.study.security.config.a;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 권한 부여 관리를 위한 구성 클래스
 */
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {

    // 권한 부여 관리
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
