package com.ssn.design.patterns.service.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeprecatedOrder {

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 商品信息
     */
    private String productId;

    /**
     * 订单状态
     */
    private String state;
}
