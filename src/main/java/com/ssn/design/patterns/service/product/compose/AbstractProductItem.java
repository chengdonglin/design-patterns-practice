package com.ssn.design.patterns.service.product.compose;

/**
 * Component组件
 */
public class AbstractProductItem {

    protected void addProductItem(AbstractProductItem item) {
        throw new UnsupportedOperationException("Not Support child add");
    }

    protected void delProductChild(AbstractProductItem item) {
        throw new UnsupportedOperationException("Not Support child del");
    }
}
