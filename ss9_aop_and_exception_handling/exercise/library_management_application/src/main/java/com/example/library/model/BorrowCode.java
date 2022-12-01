package com.example.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity

public class BorrowCode {
    @Id
    private String id;
    @OneToMany
    private Set<Book> bookSet;

    public BorrowCode() {
    }

    public BorrowCode(String id, String borrowCode, Set<Book> bookSet) {
        this.id = id;
        this.bookSet = bookSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
