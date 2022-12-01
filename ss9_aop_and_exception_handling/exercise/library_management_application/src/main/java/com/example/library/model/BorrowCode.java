package com.example.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity

public class BorrowCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String borrowCode;
    @OneToMany
    private Set<Book> bookSet;

    public BorrowCode() {
    }

    public BorrowCode(Integer id, String borrowCode, Set<Book> bookSet) {
        this.id = id;
        this.borrowCode = borrowCode;
        this.bookSet = bookSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
