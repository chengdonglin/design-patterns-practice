package com.ssn.design.patterns.service.product.vistor;

import com.ssn.design.patterns.cache.RedisCommonProcessor;
import com.ssn.design.patterns.service.product.compose.AbstractProductItem;
import com.ssn.design.patterns.service.product.compose.ProductComposite;
import org.springframework.stereotype.Component;

@Component
public class DelItemVisitor implements ItemVisitor<AbstractProductItem> {

    private final RedisCommonProcessor processor;

    public DelItemVisitor(RedisCommonProcessor processor) {
        this.processor = processor;
    }

    @Override
    public AbstractProductItem visitor(AbstractProductItem productItem) {
        ProductComposite currentItem = (ProductComposite)processor.get("items");
        ProductComposite delItem = (ProductComposite)productItem;
        if (delItem.getId().equals(currentItem.getId())) {
            throw new UnsupportedOperationException("can not delete root");
        }
        // 如果删除的节点的父节点为当前节点，直接删除
        if (delItem.getPid().equals(currentItem.getId())) {
            currentItem.delProductChild(delItem);
            return currentItem;
        }
        delChild(delItem,currentItem);
        return currentItem;
    }

    private void delChild(ProductComposite delItem, ProductComposite currentItem) {
        for (AbstractProductItem abstractProductItem : currentItem.getChild()) {
            ProductComposite item = (ProductComposite)abstractProductItem;
            if (item.getId().equals(delItem.getPid())) {
                item.delProductChild(delItem);
                break;
            } else {
                delChild(delItem,item);
            }
        }
    }
}
