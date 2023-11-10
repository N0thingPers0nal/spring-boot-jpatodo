package com.springtodo.springbootjpatodo.controller;

import com.springtodo.springbootjpatodo.models.AppUser;
import com.springtodo.springbootjpatodo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public AppUser login(@RequestBody AppUser user) {
        return userService.login(user);
    }
    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user){
        return userService.register(user);
    }
}
