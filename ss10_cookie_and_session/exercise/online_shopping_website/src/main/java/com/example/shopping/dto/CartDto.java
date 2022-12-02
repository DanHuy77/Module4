package com.example.shopping.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }


    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void removeProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + -1);
        }
    }


    public Double getTotal() {
        double total = 0;
        Set<ProductDto> set = productMap.keySet();
        for (ProductDto key : set) {
            total += key.getPrice() * productMap.get(key);
        }
        return total;
    }
}
