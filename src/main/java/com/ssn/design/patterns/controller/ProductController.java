package com.ssn.design.patterns.controller;

import com.ssn.design.patterns.service.product.compose.ProductComposite;
import com.ssn.design.patterns.service.product.compose.ProductItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductItemService productItemService;

    public ProductController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }

    @PostMapping("fetchAllItems")
    public ProductComposite fetchAllItems() {
        return productItemService.fetchAllItems();
    }
}
