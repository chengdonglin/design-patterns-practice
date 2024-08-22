package com.ssn.design.patterns.service.bridge;

import com.ssn.design.patterns.service.bridge.type.NormalMessageSend;
import com.ssn.design.patterns.service.bridge.type.UrgencyMessageSend;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2024-08-15 10:43
 * @PackageName:com.ssn.design.patterns.service.bridge
 * @ClassName: MessageBridgeConfig
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class MessageBridgeConfig {

    private final MessageSend emailMessageSend;

    private final MessageSend smsMessageSend;

    public MessageBridgeConfig(MessageSend emailMessageSend, MessageSend smsMessageSend) {
        this.emailMessageSend = emailMessageSend;
        this.smsMessageSend = smsMessageSend;
    }

    @Bean
    public NormalMessageSend normalMessageSendWithEmail() {
        return new NormalMessageSend(emailMessageSend);
    }

    @Bean
    public NormalMessageSend normalMessageSendWithSms() {
        return new NormalMessageSend(smsMessageSend);
    }


    @Bean
    public UrgencyMessageSend urgencyMessageSendWithEmail() {
        return new UrgencyMessageSend(emailMessageSend);
    }

    @Bean
    public UrgencyMessageSend urgencyMessageSendWithSms() {
        return new UrgencyMessageSend(smsMessageSend);
    }
}
