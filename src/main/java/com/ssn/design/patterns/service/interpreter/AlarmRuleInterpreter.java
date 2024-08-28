package com.ssn.design.patterns.service.interpreter;

import java.util.Map;

/**
 * @Author linchengdong
 * @Date 2024-08-28 15:39
 * @PackageName:com.ssn.design.patterns.service.interpreter
 * @ClassName: AlarmRuleInterpreter
 * @Description: TODO
 * @Version 1.0
 */
public class AlarmRuleInterpreter {

    private Expression expression;

    public AlarmRuleInterpreter(Expression expression) {
        this.expression = expression;
    }

    public boolean Interpret(Map<String,Long> params) {
        return this.expression.Interpret(params);
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
