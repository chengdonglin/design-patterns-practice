package com.ssn.design.patterns.service;

import com.ssn.design.patterns.pojo.UserRepository;
import com.ssn.design.patterns.repo.UserInfo;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String account,String password) {
        UserInfo userInfo = userRepository.findByUsernameAndUserPassword(account, password);
        if (userInfo == null) {
            return "account/ password error";
        }
        return "Login Success";
    }

    public String register(UserInfo userInfo) {
        if (checkUserExist(userInfo.getUsername())) {
            throw new RuntimeException("user already registed");
        }
        userInfo.setCreateTime(new Date());
        userRepository.save(userInfo);
        return "register success";
    }

    private boolean checkUserExist(String username) {
        UserInfo userInfo = userRepository.findByUsername(username);
        if (userInfo == null){
            return false;
        }
        return true;
    }
}
