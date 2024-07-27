package com.ssn.design.patterns.service.product;

import com.ssn.design.patterns.cache.RedisCommonProcessor;
import com.ssn.design.patterns.pojo.ProductItem;
import com.ssn.design.patterns.repo.ProductItemRepository;
import com.ssn.design.patterns.service.product.compose.AbstractProductItem;
import com.ssn.design.patterns.service.product.compose.ProductComposite;
import com.ssn.design.patterns.service.product.vistor.AddItemVisitor;
import com.ssn.design.patterns.service.product.vistor.DelItemVisitor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductItemService {

    private final RedisCommonProcessor redisCommonProcessor;

    private final ProductItemRepository productItemRepository;

    private final AddItemVisitor addItemVisitor;

    private final DelItemVisitor delItemVisitor;

    public ProductItemService(RedisCommonProcessor redisCommonProcessor, ProductItemRepository productItemRepository, AddItemVisitor addItemVisitor, DelItemVisitor delItemVisitor) {
        this.redisCommonProcessor = redisCommonProcessor;
        this.productItemRepository = productItemRepository;
        this.addItemVisitor = addItemVisitor;
        this.delItemVisitor = delItemVisitor;
    }

    public ProductComposite fetchAllItems() {
        Object cacheItems = redisCommonProcessor.get("items");
        if (cacheItems != null) {
            return (ProductComposite) cacheItems;
        }
        List<ProductItem> fetchDbItems = productItemRepository.findAll();
        ProductComposite items = genegateProductTree(fetchDbItems);
        if (items == null) {
            throw new UnsupportedOperationException("Product Items should not be in DB");
        }
        redisCommonProcessor.set("items",items);
        return items;
    }


    private ProductComposite genegateProductTree(List<ProductItem> fetchDbItems) {
        List<ProductComposite> composites = new ArrayList<>();
        fetchDbItems.forEach(dbItem -> {
            composites.add(ProductComposite.builder()
                    .id(dbItem.getId()).name(dbItem.getName()).pid(dbItem.getPid())
                    .build()
            );
        });
        Map<Integer, List<ProductComposite>> groupingList = composites.stream().collect(Collectors.groupingBy(ProductComposite::getPid));
        composites.stream().forEach(item -> {
            List<ProductComposite> list = groupingList.get(item.getId());
            item.setChild(list == null ? new ArrayList<>() : list.stream().map(x -> (AbstractProductItem)x).collect(Collectors.toList()));
        });
        ProductComposite composite = composites.size() == 0 ? null : composites.get(0);
        return composite;
    }


    @Transactional(rollbackFor = Exception.class)
    public ProductComposite addItems(ProductItem item) {
        // 更新数据库
        productItemRepository.addItem(item.getName(),item.getPid());
        ProductItem productItem = productItemRepository.findByNameAndPid(item.getName(), item.getPid());
        ProductComposite addItem = ProductComposite.builder()
                .id(productItem.getId())
                .name(productItem.getName())
                .pid(productItem.getPid())
                .child(new ArrayList<>())
                .build();
        AbstractProductItem updateItems = addItemVisitor.visitor(addItem);
        redisCommonProcessor.set("items",updateItems);
        return (ProductComposite) updateItems;
    }


    @Transactional(rollbackFor = Exception.class)
    public ProductComposite delItems(ProductItem item) {
        productItemRepository.delItem(item.getId());
        ProductComposite delItem = ProductComposite.builder()
                .id(item.getId())
                .name(item.getName())
                .pid(item.getPid()).build();
        AbstractProductItem updateItems = delItemVisitor.visitor(delItem);
        redisCommonProcessor.set("items",updateItems);
        return (ProductComposite) updateItems;
    }
}
