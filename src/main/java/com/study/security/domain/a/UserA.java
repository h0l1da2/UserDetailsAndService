package com.study.security.domain.a;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

// JPA UserEntityClass
@Entity
@Data
public class UserA {

    @Id
    private int id;
    private String username;
    private String password;
    private String authority;
}
