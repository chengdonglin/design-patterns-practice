package com.ssn.design.patterns.service.order;

import com.ssn.design.patterns.service.order.concrete.DeprecatedCreateOrder;
import com.ssn.design.patterns.service.order.concrete.DeprecatedPayOrder;
import com.ssn.design.patterns.service.order.concrete.DeprecatedReceiveOrder;
import com.ssn.design.patterns.service.order.concrete.DeprecatedSendOrder;
import org.springframework.stereotype.Component;

/**
 * 环境角色-Context上下文角色，暴露给客户端使用
 */
@Component
public class DeprecatedOrderContext {

    /**
     * 新创建订单的初始化状态
     */
    private final DeprecatedCreateOrder deprecatedCreateOrder;

    private final DeprecatedSendOrder deprecatedSendOrder;

    private final DeprecatedReceiveOrder deprecatedReceiveOrder;

    private final DeprecatedPayOrder deprecatedPayOrder;

    public DeprecatedOrderContext(DeprecatedCreateOrder deprecatedCreateOrder, DeprecatedSendOrder deprecatedSendOrder, DeprecatedReceiveOrder deprecatedReceiveOrder, DeprecatedPayOrder deprecatedPayOrder) {
        this.deprecatedCreateOrder = deprecatedCreateOrder;
        this.deprecatedSendOrder = deprecatedSendOrder;
        this.deprecatedReceiveOrder = deprecatedReceiveOrder;
        this.deprecatedPayOrder = deprecatedPayOrder;
    }


    /**
     * 创建订单入口，直接调用状态类的createOrder方法
     * @param orderId
     * @param productId
     * @return
     */
    public DeprecatedOrder createOrder(String orderId,String productId) {
        DeprecatedOrder order = deprecatedCreateOrder.createOrder(orderId, productId);
        return order;
    }

    /**
     * 支付订单的方法入口，直接调用状态类的payOrder方法
     * @param orderId
     * @return
     */
    public DeprecatedOrder payOrder(String orderId) {
        DeprecatedOrder order = deprecatedPayOrder.payOrder(orderId);
        return order;
    }

    /**
     * 发送订单的方法入口，直接调用状态类的sendOrder方法
     * @param orderId
     * @return
     */
    public DeprecatedOrder sendOrder(String orderId) {
        DeprecatedOrder order = deprecatedSendOrder.sendOrder(orderId);
        return order;
    }



    /**
     * 接收订单的方法入口，直接调用状态类的 receiveOrder 方法
     * @param orderId
     * @return
     */
    public DeprecatedOrder receiveOrder(String orderId) {
        DeprecatedOrder order = deprecatedReceiveOrder.receiveOrder(orderId);
        return order;
    }

}
