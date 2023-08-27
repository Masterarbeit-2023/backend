package com.example.backend.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class User extends BaseModel {
    public String email;
    public String password;
    public List<GrantedAuthority> authorities;
}
