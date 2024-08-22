package com.ssn.design.patterns.service.bridge.send;

import com.ssn.design.patterns.service.bridge.MessageSend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2024-08-15 10:31
 * @PackageName:com.ssn.design.patterns.service.bridge.send.impl
 * @ClassName: EmailMessageSend
 * @Description: 发送短信消息
 * @Version 1.0
 */
@Component
@Slf4j
public class EmailMessageSend implements MessageSend {
    @Override
    public void send(String message, String target) {
        log.info("Use email send message :{} to user :{}",message,target);
    }

}
