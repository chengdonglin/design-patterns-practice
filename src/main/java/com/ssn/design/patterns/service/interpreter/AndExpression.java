package com.ssn.design.patterns.service.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author linchengdong
 * @Date 2024-08-28 15:19
 * @PackageName:com.ssn.design.patterns.service.interpreter
 * @ClassName: AndExpression
 * @Description: TODO
 * @Version 1.0
 */
public class AndExpression implements Expression{

    private List<Expression> expressions = new ArrayList<>();

    public AndExpression(String expression) {
        String[] splitExpressions = expression.split("&&");
        for (String expr : splitExpressions) {
            if (expr.contains(">")) {
                expressions.add(new GreaterExpression(expr));
            } else if (expr.contains("<")) {
                expressions.add(new LessExpression(expr));
            } else if (expr.contains("==")) {
                expressions.add(new EqualExpression(expr));
            } else {
                throw new UnsupportedOperationException("不支持的类型： " + expr);
            }
        }
    }

    public AndExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean Interpret(Map<String,Long> params) {
        for (Expression expression : expressions) {
            if (!expression.Interpret(params)) {
                return false;
            }
        }
        return true;
    }
}
