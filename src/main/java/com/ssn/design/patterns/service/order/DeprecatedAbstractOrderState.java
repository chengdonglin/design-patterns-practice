package com.ssn.design.patterns.service.order;

/**
 * 创建State抽象状态组件，定义状态以及方法
 */
public abstract class DeprecatedAbstractOrderState {

    /**
     * 订单状态定义：待支付，待发货，待收货，订单完成
     */
    protected final String ORDER_WAIT_PAY = "ORDER_WAIT_PAY";

    protected final String ORDER_WAIT_SEND = "ORDER_WAIT_SEND";

    protected final String ORDER_WAIT_RECEIVE = "ORDER_WAIT_RECEIVE";

    protected final String ORDER_FINISH = "ORDER_FINISH";

    /**
     * 订单方法-创建订单
     * @param orderId
     * @param productId
     * @return
     */
    protected DeprecatedOrder createOrder(String orderId,String productId) {
        throw new UnsupportedOperationException();
    }

    /**
     * 订单方法-订单支付
     * @param orderId
     * @return
     */
    protected DeprecatedOrder payOrder(String orderId) {
        throw new UnsupportedOperationException();
    }

    /**
     * 订单方法-订单发送
     * @param orderId
     * @return
     */
    protected DeprecatedOrder sendOrder(String orderId) {
        throw new UnsupportedOperationException();
    }

    /**
     * 订单方法-订单签收
     * @param orderId
     * @return
     */
    protected DeprecatedOrder receiveOrder(String orderId) {
        throw new UnsupportedOperationException();
    }
}
