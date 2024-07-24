package com.ssn.design.patterns.controller;

import com.ssn.design.patterns.pojo.UserInfo;
import com.ssn.design.patterns.service.login.UserService;
import com.ssn.design.patterns.service.login.adapter.Login3rdAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Login3rdAdapter login3rdAdapter;


    public UserController(Login3rdAdapter login3rdAdapter) {
        this.login3rdAdapter = login3rdAdapter;

    }

    @PostMapping("login")
    public String login(@RequestParam String account, @RequestParam String password) {
        return login3rdAdapter.login(account, password);
    }

    @PostMapping("register")
    public String register(@RequestBody UserInfo userInfo) {
        return login3rdAdapter.register(userInfo);
    }

    @PostMapping("login/gitee")
    public String loginByGitee(@RequestParam String code,@RequestParam String state) {
        return login3rdAdapter.loginByGitee(code, state);
    }
}
