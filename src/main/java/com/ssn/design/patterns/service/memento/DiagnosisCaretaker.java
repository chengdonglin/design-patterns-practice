package com.ssn.design.patterns.service.memento;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author linchengdong
 * @Date 2024-08-27 17:26
 * @PackageName:com.ssn.design.patterns.memento
 * @ClassName: DiagnosisCaretaker
 * @Description: Caretaker类负责保存和恢复备忘录
 * @Version 1.0
 */
public class DiagnosisCaretaker {

    private final RedisTemplate redisTemplate;


    public DiagnosisCaretaker(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveMemento(String key,DiagnosisMemento memento) {
        redisTemplate.opsForList().rightPush(key,memento.getReportContent());
    }

    public DiagnosisMemento retrieveMemento(String key,long index) {
        String diagnosisContext = (String)redisTemplate.opsForList().index(key, index);
        return new DiagnosisMemento(diagnosisContext);
    }

    public Long getDiagnosisListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    public void clear(String key) {
        redisTemplate.delete(key);
    }
}
