package com.ssn.design.patterns.service.product.compose;

import lombok.NoArgsConstructor;

/**
 * Component组件
 */
@NoArgsConstructor
public class AbstractProductItem {

    protected void addProductItem(AbstractProductItem item) {
        throw new UnsupportedOperationException("Not Support child add");
    }

    protected void delProductChild(AbstractProductItem item) {
        throw new UnsupportedOperationException("Not Support child del");
    }
}
