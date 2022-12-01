package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BorrowCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowCodeService {
    Page<BorrowCode> findAll(Pageable pageable);

    Book findById(Integer id);

    void save(BorrowCode borrowCode);

    void remove(Integer id);
}
