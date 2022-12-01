package com.example.library.service.impl;

import com.example.library.model.Book;
import com.example.library.model.BorrowCode;
import com.example.library.repository.IBorrowCodeRepository;
import com.example.library.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowCodeService implements IBorrowCodeService {

    @Autowired
    private IBorrowCodeRepository borrowCodeRepository;

    @Override
    public Page<BorrowCode> findAll(Pageable pageable) {
        return borrowCodeRepository.findAll(pageable);
    }

    @Override
    public BorrowCode findById(Integer id) {
        return borrowCodeRepository.findById(id).get();
    }

    @Override
    public void save(BorrowCode borrowCode) {
        borrowCodeRepository.save(borrowCode);
    }

    @Override
    public void remove(Integer id) {
        borrowCodeRepository.deleteById(id);
    }
}
