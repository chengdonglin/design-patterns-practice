package com.ssn.design.patterns.service.order.concrete;

import com.ssn.design.patterns.cache.RedisCommonProcessor;
import com.ssn.design.patterns.service.order.DeprecatedAbstractOrderState;
import com.ssn.design.patterns.service.order.DeprecatedOrder;
import com.ssn.design.patterns.service.order.DeprecatedOrderContext;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedCreateOrder extends DeprecatedAbstractOrderState {

    /**
     * 订单数据存储在redis
     */
    private final RedisCommonProcessor processor;

    /**
     * 订单创建完成之后的下一个状态：待支付
     */
    private final DeprecatedPayOrder deprecatedPayOrder;

    public DeprecatedCreateOrder(RedisCommonProcessor processor, DeprecatedPayOrder deprecatedPayOrder) {
        this.processor = processor;
        this.deprecatedPayOrder = deprecatedPayOrder;
    }

    /**
     * 订单创建成功之后， 将订单状态改为待支付
     * @param orderId
     * @param productId
     * @return
     */
    @Override
    public DeprecatedOrder createOrder(String orderId, String productId) {
        DeprecatedOrder order = DeprecatedOrder.builder()
                .orderId(orderId)
                .productId(productId)
                .state(ORDER_WAIT_PAY)
                .build();
        // 订单放入Redis缓存，15分钟失效
        processor.set(orderId,order,900);
        return order;
    }
}
