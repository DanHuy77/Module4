package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.ConnectorUtil;
import com.example.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> showProductList() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectorUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void addNewProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectorUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(product);

            transaction.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void editProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectorUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.merge(product);

            transaction.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void removeProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectorUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(product);

            transaction.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectorUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id  =:id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return product;
    }

    @Override
    public List<Product> searchByName(String name) {
        Session session = null;
        List<Product> productList = new ArrayList<>();
        try {
            session = ConnectorUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product WHERE name LIKE:name").setParameter("name", "%" + name + "%").getResultList();
        } catch (NoResultException e) {
            e.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }
}
