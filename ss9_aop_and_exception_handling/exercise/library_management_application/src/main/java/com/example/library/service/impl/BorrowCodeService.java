package com.example.library.service.impl;

import com.example.library.model.Book;
import com.example.library.model.BorrowCode;
import com.example.library.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//@Service
public class BorrowCodeService implements IBorrowCodeService {

    @Autowired
    private IBorrowCodeService borrowCodeService;

    @Override
    public Page<BorrowCode> findAll(Pageable pageable) {
        return borrowCodeService.findAll(pageable);
    }

    @Override
    public Book findById(Integer id) {
        return borrowCodeService.findById(id);
    }

    @Override
    public void save(BorrowCode borrowCode) {
        borrowCodeService.save(borrowCode);
    }

    @Override
    public void remove(Integer id) {
        borrowCodeService.remove(id);
    }
}
