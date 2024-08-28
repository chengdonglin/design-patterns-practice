package com.ssn.design.patterns.service.visitor.user;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @Author linchengdong
 * @Date 2024-08-23 15:13
 * @PackageName:com.ssn.design.patterns.service.visitor.user
 * @ClassName: Teacher
 * @Description: TODO
 * @Version 1.0
 */
@Getter
public class Teacher extends User{


    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(UserVisitor visitor) {
        visitor.visit(this);
    }

    //升学率
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


}
