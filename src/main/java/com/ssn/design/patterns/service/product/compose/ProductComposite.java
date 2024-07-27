package com.ssn.design.patterns.service.product.compose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Composite 树枝组件
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductComposite extends AbstractProductItem{

    private Integer id;

    private String name;

    private Integer pid;

    private List<AbstractProductItem> child = new ArrayList<>();

    /**
     * 新增商品类目
     * @param item
     */
    @Override
    public void addProductItem(AbstractProductItem item) {
        this.child.add(item);
    }

    /**
     * 移除商品类目
     * @param item
     */
    @Override
    public void delProductChild(AbstractProductItem item) {
        ProductComposite removeItem = (ProductComposite)item;
        Iterator iterator = child.iterator();
        while (iterator.hasNext()) {
            ProductComposite composite = (ProductComposite)iterator.next();
            if (composite.getId().equals(removeItem.getId())) {
                iterator.remove();
                break;
            }
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<AbstractProductItem> getChild() {
        return child;
    }

    public void setChild(List<AbstractProductItem> child) {
        this.child = child;
    }
}
