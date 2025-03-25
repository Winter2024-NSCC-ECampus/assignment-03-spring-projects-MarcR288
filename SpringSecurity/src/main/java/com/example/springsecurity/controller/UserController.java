package com.example.springsecurity.controller;

import com.example.springsecurity.model.Users;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String confirmPassword,
                          RedirectAttributes redirectAttributes
        ) {

        if (userService.findByUsername(username).isPresent()) {
            redirectAttributes.addFlashAttribute("usernameError", "Username is already taken");
            System.out.println("Username is already taken: " + username);
            return "redirect:/register";
        }

        if (!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("passwordError", "Passwords do not match");
            return "redirect:/register";
        }

        Users user = new Users(username, password);
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        System.out.println("Saving user: " + user);
        userService.registerUser(user);

        redirectAttributes.addFlashAttribute("successMessage", "User has been registered successfully");
        return "redirect:/login";
    }
}
