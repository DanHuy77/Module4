package com.example.repository;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> showCustomerList();
    Customer findById(int id);
    boolean add(Customer customer);
    boolean update(int id, Customer customer);
    boolean remove(int id);
}
