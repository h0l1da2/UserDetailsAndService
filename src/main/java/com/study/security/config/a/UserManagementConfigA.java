//package com.study.security.config.a;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
///**
// * 사용자 관리와 암호 관리를 위한 클래스
// */
//@Configuration
//public class UserManagementConfigA {
//
//    // 유저 관리하기 위한 등록
//    @Bean
//    public UserDetailsService userDetailsService() {
//        //UserDetailsService
//        var userDetailsService = new InMemoryUserDetailsManager();
//
//        //UserDetails
//        var user =
//                User.withUsername("hyuil")
//                        .password("aaaa")
//                        .authorities("ADMIN")
//                        .build(); //UserDetails 에 유저 등록
//
//        // 이제부터 이 유저는 제가 관리합니다
//        userDetailsService.createUser(user);
//
//        return userDetailsService;
//    }
//
//    // UserDetailsService 커스텀했으니 얘도 필수
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
