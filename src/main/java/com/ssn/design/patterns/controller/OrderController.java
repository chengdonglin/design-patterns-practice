package com.ssn.design.patterns.controller;

import com.ssn.design.patterns.service.order.DeprecatedOrder;
import com.ssn.design.patterns.service.order.DeprecatedOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    private final DeprecatedOrderService deprecatedOrderService;

    public OrderController(DeprecatedOrderService deprecatedOrderService) {
        this.deprecatedOrderService = deprecatedOrderService;
    }

    @PostMapping("create")
    public DeprecatedOrder createOrder(@RequestParam String productId) {
        return deprecatedOrderService.createOrder(productId);
    }

    @PostMapping("pay")
    public DeprecatedOrder payOrder(@RequestParam String orderId) {
        return deprecatedOrderService.pay(orderId);
    }



    @PostMapping("send")
    public DeprecatedOrder sendOrder(@RequestParam String orderId) {
        return deprecatedOrderService.send(orderId);
    }

    @PostMapping("receive")
    public DeprecatedOrder receiveOrder(@RequestParam String orderId) {
        return deprecatedOrderService.receive(orderId);
    }
}
