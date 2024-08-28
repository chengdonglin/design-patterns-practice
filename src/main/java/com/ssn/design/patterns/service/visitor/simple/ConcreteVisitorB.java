package com.ssn.design.patterns.service.visitor.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author linchengdong
 * @Date 2024-08-23 14:25
 * @PackageName:com.ssn.design.patterns.service.visitor.simple
 * @ClassName: ConcreteVisitorA
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class ConcreteVisitorB implements Visitor{
    @Override
    public void visit(ConcreteElementA element) {
      log.info("访问者B，访问 {}",element.operation());
    }

    @Override
    public void visit(ConcreteElementB element) {
        log.info("访问者B，访问 {}",element.operation());
    }


}
