package com.ssn.design.patterns.service.login.adapter;

import com.alibaba.fastjson.JSONObject;
import com.ssn.design.patterns.pojo.UserInfo;
import com.ssn.design.patterns.repo.UserRepository;
import com.ssn.design.patterns.service.login.UserService;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 设配器Adapter角色
 */
@Component
public class Login3rdAdapter extends UserService implements Login3rdTarget {

    public Login3rdAdapter(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public String loginByGitee(String code, String state) {

        // 根据code 请求gitee 获取 access_token

        // 根据access_token 获取用户信息
        JSONObject userInfo = new JSONObject(); // 假设这个就是gitee返回回来的数据
        String username = "gitee@" + userInfo.get("name");
        String password = username;
        return autoRegister3rdAndLogin(username,password);
    }

    private String autoRegister3rdAndLogin(String username, String password) {
        if (super.checkUserExist(username)) {
            // 如果第三方账号已注册， 直接登录
            return super.login(username,password);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setUserPassword(password);
        userInfo.setCreateTime(new Date());
        super.register(userInfo);
        return super.login(username,password);
    }

    @Override
    public String loginByWechat(String... params) {
        return null;
    }

    @Override
    public String loginByQQ(String... params) {
        return null;
    }

    @Override
    public String loginDefault(String username, String password) {
        return super.login(username,password);
    }
}
