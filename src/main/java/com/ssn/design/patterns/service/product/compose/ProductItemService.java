package com.ssn.design.patterns.service.product.compose;

import com.ssn.design.patterns.cache.RedisCommonProcessor;
import com.ssn.design.patterns.pojo.ProductItem;
import com.ssn.design.patterns.repo.ProductItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductItemService {

    private final RedisCommonProcessor redisCommonProcessor;

    private final ProductItemRepository productItemRepository;

    public ProductItemService(RedisCommonProcessor redisCommonProcessor, ProductItemRepository productItemRepository) {
        this.redisCommonProcessor = redisCommonProcessor;
        this.productItemRepository = productItemRepository;
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
}
