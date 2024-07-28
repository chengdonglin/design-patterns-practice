package com.ssn.design.patterns.service.order.concrete;

import com.ssn.design.patterns.cache.RedisCommonProcessor;
import com.ssn.design.patterns.service.order.DeprecatedAbstractOrderState;
import com.ssn.design.patterns.service.order.DeprecatedOrder;
import com.ssn.design.patterns.service.order.DeprecatedOrderContext;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedPayOrder extends DeprecatedAbstractOrderState {

    private final RedisCommonProcessor processor;

    private final DeprecatedSendOrder deprecatedSendOrder;

    public DeprecatedPayOrder(RedisCommonProcessor processor, DeprecatedSendOrder deprecatedSendOrder) {
        this.processor = processor;
        this.deprecatedSendOrder = deprecatedSendOrder;
    }

    /**
     * 订单支付成功，将状态设置为代发货
     * @param orderId
     * @param context
     * @return
     */
    @Override
    public DeprecatedOrder payOrder(String orderId) {
        DeprecatedOrder order = (DeprecatedOrder)processor.get(orderId);
        if (!order.getState().equals(ORDER_WAIT_PAY)) {
            throw new UnsupportedOperationException("Order state should be ORDER_WAITING_PAY,But now " + order.getState());
        }
        // 支付完成，订单状态，改为代发货
        order.setState(ORDER_WAIT_SEND);
        processor.set(orderId,order);
        // todo 观察者模式， 订单完成发送event
        return order;
    }
}
