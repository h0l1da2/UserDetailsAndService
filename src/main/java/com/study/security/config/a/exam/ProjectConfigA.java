package com.study.security.config.a.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfigA extends WebSecurityConfigurerAdapter {

    /**
     * 인증공급자 (AuthenticationProvider) 가 이용하는 서비스
     */
    @Bean
    public UserDetailsService userDetailsService() {
        //UserDetailsService
        var userDetailsService = new InMemoryUserDetailsManager();

        //UserDetails
        var user =
                User.withUsername("hyuil")
                        .password("aaaa")
                        .authorities("ADMIN")
                        .build(); //UserDetails 에 유저 등록

        // 이제부터 이 유저는 제가 관리합니다
        userDetailsService.createUser(user);

        return userDetailsService;
    }

    /**
     * userDetailsService 를 재정의하면
     * passwordEncoder 도 재정의 해줘야함
     */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic();
//        http.authorizeRequests() // 모든 요청은 인증을 해야지만 동작
//                .anyRequest().authenticated();
        http.httpBasic();
        http.authorizeRequests() // 모든 요청 인증없이 동작 O
                .anyRequest().permitAll();
    }

    // AuthenticationProvider
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //UserDetailsService
        var userDetailsService = new InMemoryUserDetailsManager();

        //UserDetails
        var user =
                User.withUsername("hyuil")
                        .password("aaaa")
                        .authorities("ADMIN")
                        .build(); //UserDetails 에 유저 등록

        // 이제부터 이 유저는 제가 관리합니다
        userDetailsService.createUser(user);

        // configure 에서 서비스와, 패스워드 인코더 머 하는지 등록
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
