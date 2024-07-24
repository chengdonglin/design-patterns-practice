package com.ssn.design.patterns.controller;

import com.ssn.design.patterns.pojo.UserInfo;
import com.ssn.design.patterns.service.login.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public String login(@RequestParam String account, @RequestParam String password) {
        return userService.login(account, password);
    }

    @PostMapping("register")
    public String register(@RequestBody UserInfo userInfo) {
        return userService.register(userInfo);
    }
}
