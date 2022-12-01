package com.example.library.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer quantity;
    @ManyToOne
    private BorrowCode borrowCode;

    public Book() {
    }

    public Book(Integer id, String name, Integer quantity, BorrowCode borrowCode) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.borrowCode = borrowCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BorrowCode getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(BorrowCode borrowCode) {
        this.borrowCode = borrowCode;
    }
}
