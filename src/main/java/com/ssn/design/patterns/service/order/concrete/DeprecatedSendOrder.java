package com.ssn.design.patterns.service.order.concrete;

import com.ssn.design.patterns.cache.RedisCommonProcessor;
import com.ssn.design.patterns.service.order.DeprecatedAbstractOrderState;
import com.ssn.design.patterns.service.order.DeprecatedOrder;
import com.ssn.design.patterns.service.order.DeprecatedOrderContext;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedSendOrder extends DeprecatedAbstractOrderState {

    private final RedisCommonProcessor processor;

    private final DeprecatedReceiveOrder deprecatedReceiveOrder;

    public DeprecatedSendOrder(RedisCommonProcessor processor, DeprecatedReceiveOrder deprecatedReceiveOrder) {
        this.processor = processor;
        this.deprecatedReceiveOrder = deprecatedReceiveOrder;
    }

    /**
     * 订单发货成功，将状态设置为待收货
     * @param orderId
     * @return
     */

    @Override
    public DeprecatedOrder sendOrder(String orderId) {
        DeprecatedOrder order = (DeprecatedOrder)processor.get(orderId);
        if (!order.getState().equals(ORDER_WAIT_SEND)) {
            throw new UnsupportedOperationException("order state shou be ORDER_WAIT_SEND, CURRENT IS " + order.getState());
        }
        order.setState(ORDER_WAIT_RECEIVE);
        processor.set(orderId,order);
        //todo 观察者模式：订单发货事件
        return order;
    }
}
