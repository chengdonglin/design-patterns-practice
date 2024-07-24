package com.ssn.design.patterns.service.login.adapter;

/**
 * 目标角色
 */
public interface Login3rdTarget {

    String loginByGitee(String code,String state);

    String loginByWechat(String ...params);

    String loginByQQ(String ...params);

    String loginDefault(String username,String password);
}
