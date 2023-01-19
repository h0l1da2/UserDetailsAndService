package com.study.security.config.authority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.apache.logging.log4j.util.Base64Util.encode;

/**
 * UserDetails 를 구현하지 않아도
 * 빌더로 유저의 인스턴스를 만드는 법
 */
public class SimpleUserDetails {

    // 직접 구현하지 않아도 간편 !
    // 계정 만료 여부 등의 조건을 주지 않는다면
    // 간편 Build 도 괜찮은듯
    public UserDetails simpleUserBuildA() {
        return User.withUsername("username")
                .password("1234")
                .authorities("read", "write")
                .accountExpired(false) //계정만료여부
                .disabled(true)
                .build();
    }

    // 빌더를 이용해 UserDetails 의 다른 인스턴스로 빌더 만들기
    public UserDetails simpleUserBuildB() {
        // 유저 디테일 만들고
        UserDetails u =
                User.withUsername("username")
                .password("1234")
                .authorities("read", "write")
                .accountExpired(false) //계정만료여부
                .disabled(true) //계정비활성화여부
                .build();

        // UserBuilder builderA 만들기
        User.UserBuilder builderA = User.withUsername("user2");

        // builderA의 구성으로 UserDetails uA 만들기
        UserDetails uA = builderA
                .password("zzzz")
                .authorities("read", "write")
                // 참고로 얘는 Function<String, String>임
                // 암호를 지정한 인코딩으로 변환하기만 함
                // 나는 Base64로 변환하는 static 메서드를 불러옴
                .passwordEncoder(p -> encode(p)) //암호 인코더(인코딩을 수행하는 함수)
                .accountExpired(false)
                .disabled(true)
                .build();

        // u 의 구성으로 builderB 만들기
        User.UserBuilder builderB = User.withUserDetails(u);

        // builderB 로 UserDetails uB 만들기
        UserDetails uB = builderB.build();

        return uB;
    }
}
