package com.ssn.design.patterns.service.interpreter;

import java.util.Map;

/**
 * @Author linchengdong
 * @Date 2024-08-28 14:49
 * @PackageName:com.ssn.design.patterns.service.interpreter
 * @ClassName: Expression
 * @Description: TODO
 * @Version 1.0
 */
public interface Expression {

    boolean Interpret(Map<String,Long> param);
}
