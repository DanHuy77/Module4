package com.example.library.service;


import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Integer id);

    void save(Book book);

    void remove(Integer id);

    Book findBookByBorrowCodeContaining(String borrowCode);
}
