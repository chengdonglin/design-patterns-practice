package com.ssn.design.patterns.service.order;


import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeprecatedOrderService {

    private final DeprecatedOrderContext orderContext;


    public DeprecatedOrderService(DeprecatedOrderContext orderContext) {

        this.orderContext = orderContext;
    }

    public DeprecatedOrder createOrder(String productId) {
        String orderId = UUID.randomUUID().toString();
        return orderContext.createOrder(orderId,productId);
    }


    public DeprecatedOrder pay(String orderId) {
        return orderContext.payOrder(orderId);
    }

    public DeprecatedOrder send(String orderId) {
        return orderContext.sendOrder(orderId);
    }

    public DeprecatedOrder receive(String orderId) {
        return orderContext.receiveOrder(orderId);
    }
}
