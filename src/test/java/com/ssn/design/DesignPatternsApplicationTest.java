package com.ssn.design;

import com.ssn.design.patterns.DesignPatternsApplication;
import com.ssn.design.patterns.service.memento.DiagnosisCaretaker;
import com.ssn.design.patterns.service.memento.DiagnosisMemento;
import com.ssn.design.patterns.service.bridge.type.NormalMessageSend;
import com.ssn.design.patterns.service.bridge.type.UrgencyMessageSend;
import com.ssn.design.patterns.service.template.FileMetaDecode;
import com.ssn.design.patterns.service.template.MetaDecodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author linchengdong
 * @Date 2024-08-15 10:51
 * @PackageName:com.ssn.design
 * @ClassName: DesignPatternsApplicationTest
 * @Description: TODO
 * @Version 1.0
 */
@SpringBootTest(classes = DesignPatternsApplication.class)
@Slf4j
public class DesignPatternsApplicationTest {

    // 注入邮件发送普通消息
    @Autowired
    NormalMessageSend normalMessageSendWithEmail;

    // 注入短信发送普通消息
    @Autowired
    NormalMessageSend normalMessageSendWithSms;

    // 注入邮件发送加急消息
    @Autowired
    UrgencyMessageSend urgencyMessageSendWithEmail;

    // 注入短信发送加急消息
    @Autowired
    UrgencyMessageSend urgencyMessageSendWithSms;

    @Test
    public void test() {
        String targetEmail = "chengdong2518@163.com";
        String targetPhone = "1591xxxxxxx";
        normalMessageSendWithEmail.sendMessage("邮件发送普通消息",targetEmail);
        normalMessageSendWithSms.sendMessage("短信发送普通消息",targetPhone);


        urgencyMessageSendWithEmail.sendMessage("邮件发送加急消息",targetEmail);
        urgencyMessageSendWithSms.sendMessage("短信发送加急消息",targetPhone);


    }

    @Autowired
    private MetaDecodeFactory metaDecodeFactory;

    @Test
    public void template() {
        FileMetaDecode decode = metaDecodeFactory.getMetaDecode("TMAP");
        decode.decode("D://test//1.tmap");
        log.info("==============================");
        FileMetaDecode kfb = metaDecodeFactory.getMetaDecode("KFB");
        kfb.decode("D://test//1.kfb");
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testMemento() {
        DiagnosisCaretaker diagnosisCaretaker = new DiagnosisCaretaker(redisTemplate);
        String key = "CASEID:001";
        diagnosisCaretaker.saveMemento(key,new DiagnosisMemento("报告备份1"));
        diagnosisCaretaker.saveMemento(key,new DiagnosisMemento("报告备份2"));
        diagnosisCaretaker.saveMemento(key,new DiagnosisMemento("报告备份3"));
        diagnosisCaretaker.saveMemento(key,new DiagnosisMemento("报告备份4"));
        diagnosisCaretaker.saveMemento(key,new DiagnosisMemento("报告备份5"));

        log.info("报告备份总数量" + diagnosisCaretaker.getDiagnosisListSize(key));

        DiagnosisMemento memento = diagnosisCaretaker.retrieveMemento(key, 0);
        String reportContent = memento.getReportContent();
        log.info("获取 :{}",reportContent);

        DiagnosisMemento memento1 = diagnosisCaretaker.retrieveMemento(key, 1);
        String reportContent1 = memento1.getReportContent();
        log.info("获取 :{}",reportContent1);

        DiagnosisMemento memento2 = diagnosisCaretaker.retrieveMemento(key, 2);
        String reportContent2 = memento2.getReportContent();
        log.info("获取 :{}",reportContent2);

        log.info("清除报告");
        diagnosisCaretaker.clear(key);

        log.info("报告备份总数量" + diagnosisCaretaker.getDiagnosisListSize(key));
    }
}
