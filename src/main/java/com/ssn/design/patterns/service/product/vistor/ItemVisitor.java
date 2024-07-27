package com.ssn.design.patterns.service.product.vistor;

import com.ssn.design.patterns.service.product.compose.AbstractProductItem;

/**
 * Visitor抽象访问者
 * @param <T>
 */
public interface ItemVisitor<T> {

    // 定义公共的visitor方法之类实现
    T visitor(AbstractProductItem productItem);

}
