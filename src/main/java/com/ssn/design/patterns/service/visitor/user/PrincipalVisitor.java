package com.ssn.design.patterns.service.visitor.user;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author linchengdong
 * @Date 2024-08-23 15:19
 * @PackageName:com.ssn.design.patterns.service.visitor.user
 * @ClassName: PrincipalVisitor
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class PrincipalVisitor implements UserVisitor{
    @Override
    public void visit(Student student) {
        log.info("学生信息 姓名： {} 班级：{}", student.getName(), student.getClazz());
    }

    @Override
    public void visit(Teacher teacher) {
        log.info("老师信息 姓名： {} 班级：{} 升学率：{}", teacher.getName(), teacher.getIdentity(), teacher.entranceRatio());
    }

}
