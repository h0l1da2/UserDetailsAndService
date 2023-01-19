package com.study.security.config.a;

import com.study.security.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class ProjectConfig {

    /**
     * UserDetailsService 가 실행될때
     * 내가 만든 InMemoryUserDetailsManager 커스텀 클래스를 이용할건데요
     * 얘는 유저를 받으면, (리스트로 받음)
     * 자기가 관리하는 유저들 중에서 해당 유저가 있으면
     * 해당 유저의 UserDetails 를 돌려준답니다~
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = new User("id", "1111", "read");
        List<UserDetails> users = List.of(user);
        return new InMemoryUserDetailsManager(users);
    }

    /**
     * UserDetailsService 를 커스텀으로 직접 구현했기 때문에
     * PasswordEncoder 구현은 필수 !
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
