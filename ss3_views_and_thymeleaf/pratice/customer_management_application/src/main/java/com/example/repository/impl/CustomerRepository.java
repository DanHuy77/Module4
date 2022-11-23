package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {

    public static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Huy"));
        customerList.add(new Customer(2, "Trần"));
        customerList.add(new Customer(3, "Đặng"));
        customerList.add(new Customer(4, "Ung"));
        customerList.add(new Customer(5, "Nguyễn"));
    }

    @Override
    public List<Customer> showCustomerList() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customers : customerList) {
            if (customers.getId() == id) {
                return customers;
            }
        }
        return null;
    }

    @Override
    public boolean add(Customer customer) {
        customerList.add(customer);
        return true;
    }

    @Override
    public boolean update(int id, Customer customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                customerList.set(i, customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                customerList.remove(customerList.get(i));
                return true;
            }
        }
        return false;
    }
}
