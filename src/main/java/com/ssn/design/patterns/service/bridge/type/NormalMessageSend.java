package com.ssn.design.patterns.service.bridge.type;

import com.ssn.design.patterns.service.bridge.AbstractMessageSend;
import com.ssn.design.patterns.service.bridge.MessageSend;

/**
 * @Author linchengdong
 * @Date 2024-08-15 10:39
 * @PackageName:com.ssn.design.patterns.service.bridge.type
 * @ClassName: NormalMessage
 * @Description: 修正抽象化角色-普通消息发送
 * @Version 1.0
 */
public class NormalMessageSend extends AbstractMessageSend {

    public NormalMessageSend(MessageSend messageSend) {
        super(messageSend);
    }

    @Override
    public void sendMessage(String message, String target) {
        //对于普通消息，直接调用父类方法发送消息即可
        super.sendMessage(message, target);
    }
}
