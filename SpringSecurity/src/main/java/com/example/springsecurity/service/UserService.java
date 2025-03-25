package com.example.springsecurity.service;

import com.example.springsecurity.model.Users;
import com.example.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<Users> findByUsername(String username) {
        return Optional.ofNullable(userRepo.findByUsername(username));
    }

    public Users registerUser(Users user) {
        return userRepo.save(user);
    }

}
