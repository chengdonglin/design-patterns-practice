package com.ssn.design.patterns.service.bridge;

/**
 * @Author linchengdong
 * @Date 2024-08-15 10:35
 * @PackageName:com.ssn.design.patterns.service.bridge.send
 * @ClassName: AbstractMessageSend
 * @Description: 桥接抽象角色
 * @Version 1.0
 */
public abstract class AbstractMessageSend {

    // 持有实现部分的对象
    private final MessageSend messageSend;

    // 构造器传入实现部分的对象
    public AbstractMessageSend(MessageSend messageSend) {
        this.messageSend = messageSend;
    }

    // 发送消息，委派实现部分的方法
    public void sendMessage(String message,String target) {
        this.messageSend.send(message,target);
    }
}
