package com.example.shopping.service;

import com.example.shopping.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Integer id);

    void save(Product product);

    void remove(Integer id);
}
