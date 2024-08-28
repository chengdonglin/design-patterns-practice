package com.ssn.design.patterns.service.interpreter;

import java.util.Map;

/**
 * @Author linchengdong
 * @Date 2024-08-28 14:57
 * @PackageName:com.ssn.design.patterns.service.interpreter
 * @ClassName: Greater
 * @Description: TODO
 * @Version 1.0
 */
public class GreaterExpression implements Expression {
    private final String key;
    private final Long value;
    public GreaterExpression(String expression) {
        String[] elements = expression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].trim().equals(">")) {
            throw new UnsupportedOperationException("表达式不正确 " + expression);
        }
        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2].trim());
    }
    @Override
    public boolean Interpret(Map<String,Long> param) {
        if (!param.containsKey(key)) {
            return false;
        }
        Long targetValue = param.get(key);
        return targetValue > value;
    }

}
