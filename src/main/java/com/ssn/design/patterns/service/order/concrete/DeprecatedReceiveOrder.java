package com.ssn.design.patterns.service.order.concrete;

import com.ssn.design.patterns.cache.RedisCommonProcessor;
import com.ssn.design.patterns.service.order.DeprecatedAbstractOrderState;
import com.ssn.design.patterns.service.order.DeprecatedOrder;
import com.ssn.design.patterns.service.order.DeprecatedOrderContext;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedReceiveOrder extends DeprecatedAbstractOrderState {

    private final RedisCommonProcessor processor;

    public DeprecatedReceiveOrder(RedisCommonProcessor processor) {
        this.processor = processor;
    }

    /**
     * 订单签收成功，订单状态设置为订单完成
     * @param orderId
     * @return
     */
    @Override
    public DeprecatedOrder receiveOrder(String orderId) {
        DeprecatedOrder order = (DeprecatedOrder)processor.get(orderId);
        if (!order.getState().equals(ORDER_WAIT_RECEIVE)) {
            throw new UnsupportedOperationException("order state should be ORDER_WAIT_RECEIVE , BUT CURRENT " + order.getState());
        }
        order.setState(ORDER_FINISH);
        processor.remove(orderId);
        return order;
    }
}
