package com.study.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users;

    public InMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    /**
     * 사용자 이름으로 사용자 목록을 검색해서
     * 원하는 UserDetails 를 반환하고
     * 만약 해당 사용자가 없다면
     * UsernameNotFoundException 예외 발생시킴
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(
                        u -> u.getUsername().equals(username)
                )
                .findFirst()
                .orElseThrow(
                        () -> new UsernameNotFoundException("user not found")
                );
    }
}
