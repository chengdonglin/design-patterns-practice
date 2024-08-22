package com.ssn.design.patterns.service.bridge;

/**
 * @Author linchengdong
 * @Date 2024-08-15 10:27
 * @PackageName:com.ssn.design.patterns.service.bridge.send
 * @ClassName: Message
 * @Description: 统一的消息发送接口
 * @Version 1.0
 */
public interface MessageSend {

    void send(String message, String target);
}
