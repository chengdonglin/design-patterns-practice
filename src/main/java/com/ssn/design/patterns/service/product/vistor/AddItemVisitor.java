package com.ssn.design.patterns.service.product.vistor;

import com.ssn.design.patterns.cache.RedisCommonProcessor;
import com.ssn.design.patterns.service.product.compose.AbstractProductItem;
import com.ssn.design.patterns.service.product.compose.ProductComposite;
import org.springframework.stereotype.Component;

/**
 * ConcreteVistor具体访问者
 */
@Component
public class AddItemVisitor implements ItemVisitor<AbstractProductItem>{

    private final RedisCommonProcessor processor;

    public AddItemVisitor(RedisCommonProcessor processor) {
        this.processor = processor;
    }


    @Override
    public AbstractProductItem visitor(AbstractProductItem productItem) {
        ProductComposite currentItem = (ProductComposite)processor.get("items");
        ProductComposite addItem = (ProductComposite)productItem;
        if (addItem.getPid().equals(currentItem.getId())) {
            currentItem.addProductItem(addItem);
            return currentItem;
        }
        addChild(addItem,currentItem);
        return currentItem;
    }

    private void addChild(ProductComposite addItem, ProductComposite currentItem) {
        for (AbstractProductItem abstractProductItem : currentItem.getChild()) {
            ProductComposite item = (ProductComposite)abstractProductItem;
            if (item.getId().equals(addItem.getPid())) {
                item.addProductItem(addItem);
            } else {
                addChild(addItem,item);
            }
        }
    }
}
