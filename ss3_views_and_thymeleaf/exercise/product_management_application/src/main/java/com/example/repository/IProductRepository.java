package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showProductList();
    void addNewProduct(Product product);
    void editProduct(int id, Product product);
    void removeProduct(int id);
    Product findById(int id);
    Product searchByName(String name);
}
