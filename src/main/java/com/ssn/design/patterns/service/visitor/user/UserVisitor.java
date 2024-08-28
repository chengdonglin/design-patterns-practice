package com.ssn.design.patterns.service.visitor.user;

/**
 * @Author linchengdong
 * @Date 2024-08-23 15:09
 * @PackageName:com.ssn.design.patterns.service.visitor.user
 * @ClassName: UserVisitor
 * @Description: TODO
 * @Version 1.0
 */
public interface UserVisitor {

    void visit(Student student);

    void visit(Teacher teacher);


}
