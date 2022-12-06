package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll(Pageable pageable);

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);

}
