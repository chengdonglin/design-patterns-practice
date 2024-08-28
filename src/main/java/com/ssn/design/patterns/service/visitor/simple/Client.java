package com.ssn.design.patterns.service.visitor.simple;

/**
 * @Author linchengdong
 * @Date 2024-08-23 14:36
 * @PackageName:com.ssn.design.patterns.service.visitor.simple
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        // 添加两个访问元素A,B
        objectStructure.add(new ConcreteElementA());
        objectStructure.add(new ConcreteElementB());

        ConcreteVisitorA visitorA = new ConcreteVisitorA();
        objectStructure.accept(visitorA);

        ConcreteVisitorB visitorB = new ConcreteVisitorB();
        objectStructure.accept(visitorB);
    }
}
