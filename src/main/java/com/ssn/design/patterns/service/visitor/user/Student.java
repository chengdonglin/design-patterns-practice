package com.ssn.design.patterns.service.visitor.user;

import lombok.Data;
import lombok.Getter;

/**
 * @Author linchengdong
 * @Date 2024-08-23 15:10
 * @PackageName:com.ssn.design.patterns.service.visitor.user
 * @ClassName: Student
 * @Description: TODO
 * @Version 1.0
 */
@Getter
public class Student extends User{

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(UserVisitor visitor) {
            visitor.visit(this);
    }


    public int ranking() {
        return (int)(Math.random() * 100);
    }

}
