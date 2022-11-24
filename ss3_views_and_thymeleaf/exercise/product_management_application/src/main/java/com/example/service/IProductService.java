package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showProductList();
    void addNewProduct(Product product);
    void editProduct(Product product);
    void removeProduct(Product product);
    Product findById(int id);
    List<Product> searchByName(String name);
}
