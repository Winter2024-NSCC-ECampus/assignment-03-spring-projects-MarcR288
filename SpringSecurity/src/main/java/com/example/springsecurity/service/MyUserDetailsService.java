package com.example.springsecurity.service;

import com.example.springsecurity.model.UserPrincipal;
import com.example.springsecurity.model.Users;
import com.example.springsecurity.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private final UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return new UserPrincipal(user);
    }
}
