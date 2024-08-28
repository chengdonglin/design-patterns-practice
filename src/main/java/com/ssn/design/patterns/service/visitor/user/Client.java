package com.ssn.design.patterns.service.visitor.user;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author linchengdong
 * @Date 2024-08-23 15:24
 * @PackageName:com.ssn.design.patterns.service.visitor.user
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        DataView dataView = new DataView();
        log.info("家长视角");
        dataView.show(new ParentVisitor());

        log.info("校长视角");
        dataView.show(new PrincipalVisitor());
    }
}
