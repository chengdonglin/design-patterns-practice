package com.ssn.design.patterns.service.bridge.type;

import com.ssn.design.patterns.service.bridge.AbstractMessageSend;
import com.ssn.design.patterns.service.bridge.MessageSend;

/**
 * @Author linchengdong
 * @Date 2024-08-15 10:41
 * @PackageName:com.ssn.design.patterns.service.bridge.type
 * @ClassName: UrgencyMessageSend
 * @Description: 修正抽象化角色-加急消息发送
 * @Version 1.0
 */
public class UrgencyMessageSend extends AbstractMessageSend {

    public UrgencyMessageSend(MessageSend messageSend) {
        super(messageSend);
    }

    @Override
    public void sendMessage(String message, String target) {
        message = "加急:" + message;
        // 扩展相关功能
        super.sendMessage(message, target);
    }
}
