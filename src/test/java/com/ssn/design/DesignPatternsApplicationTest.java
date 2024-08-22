package com.ssn.design;

import com.ssn.design.patterns.DesignPatternsApplication;
import com.ssn.design.patterns.service.bridge.type.NormalMessageSend;
import com.ssn.design.patterns.service.bridge.type.UrgencyMessageSend;
import com.ssn.design.patterns.service.template.FileMetaDecode;
import com.ssn.design.patterns.service.template.MetaDecodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        decode.decode("D://test//1.kfb");
    }
}
