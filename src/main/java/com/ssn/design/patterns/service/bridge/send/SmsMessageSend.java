package com.ssn.design.patterns.service.bridge.send;

import com.ssn.design.patterns.service.bridge.MessageSend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2024-08-15 10:32
 * @PackageName:com.ssn.design.patterns.service.bridge.send.impl
 * @ClassName: SmsMessageSend
 * @Description: 短信发送消息
 * @Version 1.0
 */
@Component
@Slf4j
public class SmsMessageSend implements MessageSend {
    @Override
    public void send(String message, String target) {
        log.info("use SMS send message :{} to :{}",message,target);
    }
}
