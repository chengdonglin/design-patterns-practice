package com.ssn.design.patterns.service.visitor.simple;

/**
 * @Author linchengdong
 * @Date 2024-08-23 14:25
 * @PackageName:com.ssn.design.patterns.service.visitor.simple
 * @ClassName: ConcreteElementB
 * @Description: TODO
 * @Version 1.0
 */
public class ConcreteElementB implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operation() {
        return "具体元素B";
    }
}
