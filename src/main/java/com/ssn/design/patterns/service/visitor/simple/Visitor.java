package com.ssn.design.patterns.service.visitor.simple;

/**
 * @Author linchengdong
 * @Date 2024-08-23 14:24
 * @PackageName:com.ssn.design.patterns.service.visitor.simple
 * @ClassName: Visitor
 * @Description: 抽象访问者（Visitor）角色
 * @Version 1.0
 */
public interface Visitor {

    // 提供不同访问元素接口
    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}
