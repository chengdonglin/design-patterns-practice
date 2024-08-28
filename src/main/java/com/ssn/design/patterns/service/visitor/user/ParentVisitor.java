package com.ssn.design.patterns.service.visitor.user;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author linchengdong
 * @Date 2024-08-23 15:16
 * @PackageName:com.ssn.design.patterns.service.visitor.user
 * @ClassName: ParentVisitor
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class ParentVisitor implements UserVisitor{
    @Override
    public void visit(Student student) {
        log.info("学生信息 姓名：{} 班级：{} 排名：{}", student.getName(), student.getClazz(), student.ranking());
    }

    @Override
    public void visit(Teacher teacher) {
        log.info("老师信息 姓名：{} 班级：{}", teacher.getName(), teacher.getClazz());
    }

}
