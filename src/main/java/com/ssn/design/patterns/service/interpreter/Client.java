package com.ssn.design.patterns.service.interpreter;

import java.util.Map;

/**
 * @Author linchengdong
 * @Date 2024-08-28 16:24
 * @PackageName:com.ssn.design.patterns.service.interpreter
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {

        GreaterExpression greaterExpression = new GreaterExpression("heartRate > 60");
        AlarmRuleInterpreter alarmRuleInterpreter = new AlarmRuleInterpreter(greaterExpression);
        System.out.println(alarmRuleInterpreter.Interpret(Map.of("heartRate", 70L)));
        System.out.println(alarmRuleInterpreter.Interpret(Map.of("heartRate", 60L)));

        LessExpression lessExpression = new LessExpression("heartRate < 70");
        alarmRuleInterpreter.setExpression(lessExpression);
        System.out.println(alarmRuleInterpreter.Interpret(Map.of("heartRate",60L)));
        System.out.println(alarmRuleInterpreter.Interpret(Map.of("heartRate",71L)));


        EqualExpression equalExpression = new EqualExpression("heartRate == 70");
        alarmRuleInterpreter.setExpression(equalExpression);
        System.out.println(alarmRuleInterpreter.Interpret(Map.of("heartRate",60L)));
        System.out.println(alarmRuleInterpreter.Interpret(Map.of("heartRate",70L)));


        AndExpression andExpression = new AndExpression("SBP > 90 && SBP < 140 && DBP > 60 && DBP < 90");
        alarmRuleInterpreter.setExpression(andExpression);
        System.out.println("AND " + alarmRuleInterpreter.Interpret(Map.of("SBP", 120L, "DBP", 80L)));
        System.out.println("AND " + alarmRuleInterpreter.Interpret(Map.of("SBP", 120L, "DBP", 100L)));

        OrExpression orExpression = new OrExpression("SBP > 90 || SBP < 140 || DBP > 60 || DBP < 90");
        alarmRuleInterpreter.setExpression(orExpression);
        System.out.println("or " + alarmRuleInterpreter.Interpret(Map.of("SBP", 120L, "DBP", 80L)));

    }
}
