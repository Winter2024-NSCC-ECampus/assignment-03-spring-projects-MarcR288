package com.example.springsecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private final Users user;

    public UserPrincipal(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    //is account not expired - true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //is account not locked - true
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //is account not expired - true
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Is account enabled - true
    @Override
    public boolean isEnabled() {
        return true;
    }
}
