package com.ssn.design.patterns.service.visitor.simple;

/**
 * @Author linchengdong
 * @Date 2024-08-23 14:27
 * @PackageName:com.ssn.design.patterns.service.visitor.simple
 * @ClassName: Element
 * @Description: 抽象元素
 * @Version 1.0
 */
public interface Element {

    // 提供一个接受访问者接口
    void accept(Visitor visitor);
}
