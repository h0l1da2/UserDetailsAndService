package com.study.security.config.a.exam;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProviderA implements AuthenticationProvider {

    //인증 논리
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // Principal 인터페이스의 getName() 메서드임(상속받은거)
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        // UserDetailsService 와 PasswordEncoder 를 호출해서 사용자 이름과 암호를 테스트 하는 것을 간소화 한 거임
        if ("hyuil".equals(username) && "1234".equals("password")) {
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error in Authentication!");
        }
    }

    //Authentication 형식의 구현 해보기
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }
}
