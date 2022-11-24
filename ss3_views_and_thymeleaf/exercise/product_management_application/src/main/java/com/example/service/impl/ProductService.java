package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> showProductList() {
        return productRepository.showProductList();
    }

    @Override
    public void addNewProduct(Product product) {
        productRepository.addNewProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        productRepository.editProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        productRepository.removeProduct(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
