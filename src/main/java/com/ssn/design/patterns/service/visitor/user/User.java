package com.ssn.design.patterns.service.visitor.user;

import lombok.Getter;

/**
 * @Author linchengdong
 * @Date 2024-08-23 15:08
 * @PackageName:com.ssn.design.patterns.service.visitor.user
 * @ClassName: User
 * @Description: TODO
 * @Version 1.0
 */
@Getter
public abstract class User {

    private String name;

    private String identity;

    private String clazz;

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }


    public abstract void accept(UserVisitor visitor);


}
